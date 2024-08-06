package com.carcarcar.potato.model;

import jakarta.persistence.*;

// @Entity 어노테이션은 이 클래스가 JPA에서 사용할 엔티티임을 나타냅니다.
// 엔티티는 데이터베이스 테이블과 매핑되어 데이터가 저장되고 관리됩니다.
@Entity
public class Car {
    // @Id 어노테이션은 이 필드가 테이블의 기본 키(primary key) 역할을 한다는 것을 의미합니다.
    // 기본 키는 각 행의 고유 식별자 역할을 합니다.
    @Id
    // @GeneratedValue 어노테이션은 기본 키의 값을 생성할 방법을 지정합니다.
    // GenerationType.IDENTITY는 데이터베이스에 의존하여 자동으로 증가하는 키를 생성하게 합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 자동차의 고유 식별자

    // 자동차 브랜드를 저장하는 필드 (예: Toyota, Ford)
    private String brand;
    // 자동차 모델을 저장하는 필드 (예: Camry, Focus)
    private String model;
    // 자동차 제조 연도를 저장하는 필드
    private int modelYear;

    // JPA는 엔티티 객체가 기본 생성자를 가지고 있어야 합니다.
    // 이 생성자는 JPA 프로바이더가 엔티티 객체를 생성할 때 사용합니다.
    public Car() {}

    // 모든 필드를 초기화할 수 있는 생성자를 제공합니다.
    // 이 생성자를 사용하면 객체를 생성할 때 모든 값을 한 번에 설정할 수 있습니다.
    public Car(String brand, String model, int modelYear) {
        this.brand = brand;
        this.model = model;
        this.modelYear = modelYear;
    }

    // 각 필드에 대한 getter 및 setter 메소드.
    // 이 메소드들은 필드의 값을 읽거나 수정할 때 사용됩니다.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return modelYear;
    }

    public void setYear(int year) {
        this.modelYear = modelYear;
    }
}
