//백엔드 API(/cars)로부터 자동차 데이터를 요청하고,
// 받아온 데이터로 리스트 아이템을 만들어 웹 페이지에 표시합니다.

document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/cars')
    .then(response => response.json())
    .then(data => {
        const carList = document.getElementById('carList');
        data.forEach(car => {
            const listItem = document.createElement('li');
            listItem.textContent = `${car.brand} ${car.model} - ${car.year}`;
            carList.appendChild(listItem);
        });
    })
    .catch(error => console.error('Error:', error));
});
