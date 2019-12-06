package com.gmail.michzuerch.locateipaddress.backend.service;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.Location;
import com.gmail.michzuerch.locateipaddress.backend.data.entity.User;
import com.gmail.michzuerch.locateipaddress.backend.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.BiConsumer;

@Service
public class LocationService implements CrudService<Location> {

	private final LocationRepository locationRepository;

	@Autowired
	public LocationService(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}

	@Transactional(rollbackOn = Exception.class)
	public Location saveLocation(User currentUser, Long id, BiConsumer<User, Location> locationFiller) {
		Location location;
		if (id == null) {
			location = new Location();
		} else {
			location = load(id);
		}
		locationFiller.accept(currentUser, location);
		return locationRepository.save(location);
	}

	@Transactional(rollbackOn = Exception.class)
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	// public Page<Order> findAnyMatchingAfterDueDate(Optional<String> optionalFilter,
	// 		Optional<LocalDate> optionalFilterDate, Pageable pageable) {
	// 	if (optionalFilter.isPresent() && !optionalFilter.get().isEmpty()) {
	// 		if (optionalFilterDate.isPresent()) {
	// 			return orderRepository.findByCustomerFullNameContainingIgnoreCaseAndDueDateAfter(
	// 					optionalFilter.get(), optionalFilterDate.get(), pageable);
	// 		} else {
	// 			return orderRepository.findByCustomerFullNameContainingIgnoreCase(optionalFilter.get(), pageable);
	// 		}
	// 	} else {
	// 		if (optionalFilterDate.isPresent()) {
	// 			return orderRepository.findByDueDateAfter(optionalFilterDate.get(), pageable);
	// 		} else {
	// 			return orderRepository.findAll(pageable);
	// 		}
	// 	}
	// }

	// @Transactional
	// public List<OrderSummary> findAnyMatchingStartingToday() {
	// 	return orderRepository.findByDueDateGreaterThanEqual(LocalDate.now());
	// }

	// public long countAnyMatchingAfterDueDate(Optional<String> optionalFilter, Optional<LocalDate> optionalFilterDate) {
	// 	if (optionalFilter.isPresent() && optionalFilterDate.isPresent()) {
	// 		return orderRepository.countByCustomerFullNameContainingIgnoreCaseAndDueDateAfter(optionalFilter.get(),
	// 				optionalFilterDate.get());
	// 	} else if (optionalFilter.isPresent()) {
	// 		return orderRepository.countByCustomerFullNameContainingIgnoreCase(optionalFilter.get());
	// 	} else if (optionalFilterDate.isPresent()) {
	// 		return orderRepository.countByDueDateAfter(optionalFilterDate.get());
	// 	} else {
	// 		return orderRepository.count();
	// 	}
	// }

	// private DeliveryStats getDeliveryStats() {
	// 	DeliveryStats stats = new DeliveryStats();
	// 	LocalDate today = LocalDate.now();
	// 	stats.setDueToday((int) orderRepository.countByDueDate(today));
	// 	stats.setDueTomorrow((int) orderRepository.countByDueDate(today.plusDays(1)));
	// 	stats.setDeliveredToday((int) orderRepository.countByDueDateAndStateIn(today,
	// 			Collections.singleton(OrderState.DELIVERED)));

	// 	stats.setNotAvailableToday((int) orderRepository.countByDueDateAndStateIn(today, notAvailableStates));
	// 	stats.setNewOrders((int) orderRepository.countByState(OrderState.NEW));

	// 	return stats;
	// }

	@Override
	public JpaRepository<Location, Long> getRepository() {
		return locationRepository;
	}

	@Override
	@Transactional
	public Location createNew(User currentUser) {
		Location location = new Location();
		return location;
	}
}
