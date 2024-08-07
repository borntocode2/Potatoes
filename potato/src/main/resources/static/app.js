document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('carForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = {
            brand: document.getElementById('brand').value,
            model: document.getElementById('model').value,
            year: parseInt(document.getElementById('year').value, 10)
        };

        fetch('/cars', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        })
        .then(response => response.json())
        .then(car => {
            const carList = document.getElementById('carList');
            const listItem = document.createElement('li');
            listItem.textContent = `${car.brand} ${car.model} - ${car.year}`;
            carList.appendChild(listItem);
        })
        .catch(error => console.error('Error:', error));
    });

    // 기존 자동차 데이터 로딩
    fetch('/cars')
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
