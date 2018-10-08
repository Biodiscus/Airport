// The init method called by google maps
function initMap() {
    var marker = null;
    var ele = $(".map")[0];

    // The lat and lon of Capgemini Utrecht
    var map = new google.maps.Map(ele, {
        center: {lat: 52.099840, lng: 5.064970},
        zoom: 10
    });


    // Copied from: http://thisinterestsme.com/google-maps-api-location-picker-example/
    map.addListener("click", function(e) {
        //Get the location that the user clicked.
        var clickedLocation = e.latLng;
        //If the marker hasn't been added.
        if(marker === null){
            //Create the marker.
            marker = new google.maps.Marker({
                position: clickedLocation,
                map: map,
                draggable: true //make it draggable
            });
            //Listen for drag events!
            marker.addListener('dragend', function(event){
                markerLocation();
            });
        } else {
            //Marker has already been added, so just change its location.
            marker.setPosition(clickedLocation);
        }
        //Get the marker's location.
        markerLocation();
    });

    // Update the position
    function markerLocation() {
        var pos = marker.getPosition();

        $(".lat").val(pos.lat());
        $(".lon").val(pos.lng());
    }
}