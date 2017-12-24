function initMap() {
  var vrn = {lat: 51.67, lng: 39.2};
  var coords = {lat: 51.675, lng: 39.194};
  var markerContent= [['<h4>Test</h4>Lat:51.675, Lon: 39.194', 51.675, 39.194, "<div><img width='254' height='355' src='https://image.flaticon.com/teams/slug/freepik.jpg'</div>"]]
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 16,
    center: coords
  });

  var marker = new google.maps.Marker({
    position: coords,
    map: map
  });

  google.maps.event.addListener(marker, "click", (function(marker) {
  return function(evt) {
    infoWindow.setContent(markerContent[0][0] + markerContent[0][3]);
    infoWindow.open(map, marker);
  }
})(marker));
  var infoWindow = new google.maps.InfoWindow();
  var polygonCoords =[
    {lat: 51.679, lng: 39.194},
    {lat: 51.677, lng: 39.195},
    {lat: 51.674, lng: 39.193},
    {lat: 51.679, lng: 39.194}
  ];
  var anotherPolygonCoords =[
    {lat: 51.670, lng: 39.191},
    {lat: 51.671, lng: 39.192},
    {lat: 51.669, lng: 39.188},
    {lat: 51.670, lng: 39.191}
  ];

  var customPolygon = new google.maps.Polygon({
    paths: polygonCoords,
    strokeColor: '#FF0000',
    strokeOpacity: 0.7,
    strokeWidth: 2,
    fillColor: '#FF0000',
    fillOpacity: 0.3
  });
  var anotherCustomPolygon = new google.maps.Polygon({
    paths: anotherPolygonCoords,
    strokeColor: '#FF0000',
    strokeOpacity: 0.7,
    strokeWidth: 2,
    fillColor: '#FF0000',
    fillOpacity: 0.3
  });
  customPolygon.setMap(map);
  anotherCustomPolygon.setMap(map);
}
