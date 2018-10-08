// The init method called by google maps
var GOOGLE_MARKER = null;
var GOOGLE_MAPS = null;

function initMap() {
    var ele = $(".map")[0];

    // The lat and lon of Capgemini Utrecht
    GOOGLE_MAPS = new google.maps.Map(ele, {
        center: {lat: 52.099840, lng: 5.064970},
        zoom: 10
    });

    // Copied from: http://thisinterestsme.com/google-maps-api-location-picker-example/
    GOOGLE_MAPS.addListener("click", function(e) {
        //Get the location that the user clicked.
        var clickedLocation = e.latLng;
        //If the GOOGLE_MARKER hasn't been added.
        if(GOOGLE_MARKER === null){
            //Create the GOOGLE_MARKER.
            GOOGLE_MARKER = createMarker(clickedLocation);
            //Listen for drag events!
            GOOGLE_MARKER.addListener('dragend', function(event){
                markerLocation();
            });
        } else {
            //Marker has already been added, so just change its location.
            GOOGLE_MARKER.setPosition(clickedLocation);
        }
        //Get the GOOGLE_MARKER's location.
        markerLocation();
    });
    // Update the position
    function markerLocation() {
        var pos = GOOGLE_MARKER.getPosition();

        $(".lat").val(pos.lat());
        $(".lon").val(pos.lng());
    }
}

function createMarker(pos) {
    return new google.maps.Marker({
        position: pos,
        map: GOOGLE_MAPS,
        draggable: true //make it draggable
    });
}
