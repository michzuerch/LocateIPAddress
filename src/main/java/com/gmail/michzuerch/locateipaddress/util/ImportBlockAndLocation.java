package com.gmail.michzuerch.locateipaddress.util;

import au.com.bytecode.opencsv.CSVReader;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Block;
import com.gmail.michzuerch.locateipaddress.backend.mongodb.domain.Location;
import com.vaadin.flow.component.notification.Notification;
import org.apache.commons.net.util.SubnetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by michzuerch on 30.03.16.
 * <p>
 * Extrahiert CVS-Dateien aus einem Zip-File, interpretiert den Inhalt der CVS-Datei
 * und liefert die Daten als List zurück.
 */

public class ImportBlockAndLocation {
    private static final Logger logger = LoggerFactory.getLogger(ImportBlockAndLocation.class);

    private List<Block> blockList;
    private List<Location> locationList;

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public void importFile(byte[] val) {
        try {
            InputStream inputStream = null;
            inputStream = new ByteArrayInputStream(val);

            ZipInputStream zis = new ZipInputStream(
                    new BufferedInputStream(inputStream));
            ZipEntry entry;
            final BufferedReader reader = new BufferedReader(new InputStreamReader(zis, StandardCharsets.ISO_8859_1));
            while ((entry = zis.getNextEntry()) != null) {
                logger.debug("Entry in Zipfile found:" + entry.getName());
                if (entry.getName().endsWith("GeoLite2-City-Locations-en.csv")) {
                    logger.debug("Starte Location");
                    locationList = loadLocation(reader);
                }
                if (entry.getName().endsWith("GeoLite2-City-Blocks-IPv4.csv")) {
                    logger.debug("Starte Block");
                    blockList = loadBlock(reader);
                }
            }

            reader.close();
            zis.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Block> loadBlock(BufferedReader reader) {
        String data;
        long t = 0;
        List<Block> list = new ArrayList<>();
        try {
            reader.readLine();
            reader.readLine();
            while ((data = reader.readLine()) != null) {
                t++;
                CSVReader csvReader = new CSVReader(new StringReader(data));
                String[] parts = csvReader.readNext();
                if (parts.length != 10) {
                    Notification.show("Zeile aus Block-Datei sollte aus 10 Teilen bestehen, es sind aber " + parts.length, 5000, Notification.Position.MIDDLE);

                    logger.error("Fehler!! Keine 10 Teile in Zeile gefunden, Zeile " + t
                            + " Data[" + data + "]");
                    return null;
                }

                String network = parts[0];
                String geoname_id = parts[1];
                String registered_country_geoname_id = parts[2];
                String represented_country_geoname_id = parts[3];
                String is_anonymous_proxy = parts[4];
                String is_satellite_provider = parts[5];
                String postal_code = parts[6];
                String latitude = parts[7];
                String longitude = parts[8];
                String accuracy_radius = parts[9];


                SubnetUtils subnetUtils = new SubnetUtils(network);
                String lowIPAddress = subnetUtils.getInfo().getLowAddress();
                String highIPAddress = subnetUtils.getInfo().getHighAddress();

//                String startip = parts[1];
//                startip = startip.replaceAll("\"", "");
//                BigDecimal start = new BigDecimal(startip);
//
//                String endip = parts[2];
//                endip = endip.replaceAll("\"", "");
//                BigDecimal end = new BigDecimal(endip);
//
//                String locationData = parts[2];
//                locationData = locationData.replaceAll("\"", "");

//                System.err.println("low address: " + subnetUtils.getInfo().getLowAddress());

                Block block = new Block();
                block.setNetwork(network);
                block.setGeonameId(geoname_id);
                block.setRegisteredCountryGeonameId(registered_country_geoname_id);
                block.setRepresentedCountryGeonameId(represented_country_geoname_id);
                block.setIsAnonymousProxy(is_anonymous_proxy);
                block.setIsSatelliteProvider(is_satellite_provider);
                block.setPostalCode(postal_code);
                block.setLatitude(latitude);
                block.setLongitude(longitude);
                block.setAccuracyRadius(accuracy_radius);


                //block.setStartip(new BigDecimal(Long.valueOf(IpToLongConverter.IptoLong(lowIPAddress))));
                //block.setEndip(new BigDecimal(Long.valueOf(IpToLongConverter.IptoLong(highIPAddress))));
                list.add(block);
                logger.trace("Block " + t + "  Network:" + network + " Start:" + lowIPAddress + " End:" + highIPAddress);
            }

        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
        return list;
    }

    private List<Location> loadLocation(BufferedReader reader) {
        List<Location> list = new ArrayList<>();
        String data;
        int t = 0;
        try {
            reader.readLine();
            reader.readLine();
            while ((data = reader.readLine()) != null) {
                t++;

                CSVReader csvReader = new CSVReader(new StringReader(data));
                String[] parts = csvReader.readNext();

                if (parts.length != 14) {
                    logger.error("Fehler!! Keine 14 Teile in Zeile gefunden, Zeile " + t
                            + " Data[" + data + "]");
                    Notification.show("Zeile aus Locations-Datei sollte 14 Teile haben, es sind aber " + parts.length);
                    return null;
                }

                String geoname_id = parts[0];
                String locale_code = parts[1];
                String continent_code = parts[2];
                String continent_name = parts[3];
                String country_iso_code = parts[4];
                String country_name = parts[5];
                String subdivision_1_iso_code = parts[6];
                String subdivision_1_name = parts[7];
                String subdivision_2_iso_code = parts[8];
                String subdivision_2_name = parts[9];
                String city_name = parts[10];
                String metro_code = parts[11];
                String time_zone = parts[12];
                String is_in_european_union = parts[13];


//                String id = parts[0];
//                String country = parts[1].replaceAll("\"", "");
//                String region = parts[2].replaceAll("\"", "");
//                String city = parts[3].replaceAll("\"", "");
//                String postalcode = parts[4].replaceAll("\"", "");
//                BigDecimal lat = new BigDecimal(parts[5].replaceAll("\"", ""));
//                BigDecimal lon = new BigDecimal(parts[6].replaceAll("\"", ""));
//                String metrocode = parts[7].replaceAll("\"", "");
//                String areacode = parts[8].replaceAll("\"", "");

                Location location = new Location();
                location.setGeonameId(geoname_id);
                location.setLocaleCode(locale_code);
                location.setContinentCode(continent_code);
                location.setContinentName(continent_name);
                location.setCountryIsoCode(country_iso_code);
                location.setCountryName(country_name);
                location.setSubdivision1isoCode(subdivision_1_iso_code);
                location.setSubdivision1name(subdivision_1_name);
                location.setSubdivision2isoCode(subdivision_2_iso_code);
                location.setSubdivision2name(subdivision_2_name);
                location.setCityName(city_name);
                location.setMetroCode(metro_code);
                location.setTimeZone(time_zone);
                location.setIsInEuropeanUnion(is_in_european_union);
                list.add(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
