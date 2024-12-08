import config from "./config.js";

const {API_KEY} = config;

// Kakao Map API 스크립트를 동적으로 로드하는 함수
function loadKakaoMapScript() {
    return new Promise((resolve, reject) => {
        const script = document.createElement('script');
        script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${API_KEY}&autoload=false`;
        script.onload = () => resolve();
        script.onerror = () => reject(new Error('Failed to load Kakao Map API script'));
        document.head.appendChild(script);
    });
}

// Kakao API가 로드된 후에 실행될 함수
function initializeMap() {
    // Kakao API가 로드된 후에 호출됨
    kakao.maps.load(function () {
        var mapContainer = document.getElementById('map'),
            mapOption = {
                center: new kakao.maps.LatLng(36.3003524473678, 127.981361714912),
                level: 12
            };

        var map = new kakao.maps.Map(mapContainer, mapOption);
    });
}

function getFestivalInfo() {
    return fetch('/mapLoad')
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to get festival info');
            }
            return response.json();
        });
}

// 스크립트를 로드하고, 로드가 완료된 후 지도를 초기화
loadKakaoMapScript()
    .then(initializeMap)
    .then(getFestivalInfo)
    .catch(error => console.error(error));