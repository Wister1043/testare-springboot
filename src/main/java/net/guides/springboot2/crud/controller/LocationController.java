package net.guides.springboot2.crud.controller;

import java.util.*;

import javax.validation.Valid;

import net.guides.springboot2.crud.model.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.guides.springboot2.crud.model.Location;
import net.guides.springboot2.crud.repository.LocationRepository;

@RestController
@RequestMapping("/api/v1")
public class LocationController {
	@Autowired
	private LocationRepository locationRepository;

	@PostMapping("/location")
	public Location createEmployee(@Valid @RequestBody LocationDTO locationDTO)
	{
		Date currentDate = Calendar.getInstance().getTime();

		Location Location = new Location();
		Location.setLatitude(Double.valueOf(locationDTO.getLatitude()));
		Location.setLongitude(Double.valueOf(locationDTO.getLongitude()));
		Location.setUsername(locationDTO.getUser());
		Location.setDate(currentDate);

		return locationRepository.save(Location);
	}
}
