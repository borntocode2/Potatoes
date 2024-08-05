package com.carcarcar.potato.service;
import java.util.List;
import com.carcarcar.potato.model.Car;
import com.carcarcar.potato.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // 모든 자동차 데이터를 조회합니다.
    @Transactional(readOnly = true)
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    // 특정 ID의 자동차를 조회합니다.
    @Transactional(readOnly = true)
    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    // 자동차 데이터를 저장하거나 업데이트합니다.
    @Transactional
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    // 특정 ID의 자동차를 삭제합니다.
    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + id));

        // 각 필드 업데이트
        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());

        return carRepository.save(car);  // 변경된 정보를 데이터베이스에 저장
    }
}
