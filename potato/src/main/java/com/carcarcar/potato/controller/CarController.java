package com.carcarcar.potato.controller;

import com.carcarcar.potato.model.Car;
import com.carcarcar.potato.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "http://127.0.0.1:5500") // 프론트엔드 서버 주소

// @RestController는 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냅니다.
// 모든 메서드의 반환값은 HTTP 응답 본문으로 직접 전송됩니다.
@RestController

// @RequestMapping은 클래스 레벨에서 요청 URL의 기본 경로를 설정합니다.
// 여기서는 '/cars' 경로로 시작하는 모든 요청을 이 컨트롤러가 처리하게 됩니다.
@RequestMapping("/cars")

public class CarController {

    // @Autowired를 사용하여 스프링이 CarService 객체를 자동으로 주입하도록 합니다.
    // 이렇게 CarService 의존성이 주입되면, 이 클래스 내에서 CarService의 메소드를 사용할 수 있습니다.
    @Autowired
    private CarService carService;

    // 모든 자동차 정보를 조회하는 메소드
    // @GetMapping은 HTTP GET 요청을 처리합니다.
    // 이 메소드는 '/cars' 경로에 대한 GET 요청을 처리하며, 모든 자동차 목록을 반환합니다.
    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }

    // 특정 ID의 자동차를 조회하는 메소드
    // @PathVariable을 사용하여 URL 경로에서 'id' 값을 변수로 추출합니다.
    // 이 메소드는 '/cars/{id}' 경로에 대한 GET 요청을 처리하며, 해당 ID의 자동차 정보를 반환합니다.
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    // 자동차 정보를 생성하는 메소드
    // @PostMapping은 HTTP POST 요청을 처리합니다.
    // 이 메소드는 '/cars' 경로에 대한 POST 요청을 처리하며, 요청 본문에 포함된 자동차 정보로 새 자동차를 생성합니다.
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    // 특정 ID의 자동차 정보를 업데이트하는 메소드
    // @PutMapping은 HTTP PUT 요청을 처리합니다.
    // 이 메소드는 '/cars/{id}' 경로에 대한 PUT 요청을 처리하며, 해당 ID의 자동차 정보를 업데이트합니다.
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    // 특정 ID의 자동차를 삭제하는 메소드
    // @DeleteMapping은 HTTP DELETE 요청을 처리합니다.
    // 이 메소드는 '/cars/{id}' 경로에 대한 DELETE 요청을 처리하며, 해당 ID의 자동차를 삭제합니다.
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.ok(savedCar);
    }

}
