var FIRST_ICON = "http://maps.google.com/mapfiles/ms/micons/green.png";
var SECOND_ICON = "http://maps.google.com/mapfiles/ms/micons/blue.png";
var DEFAULT_ICON = "http://maps.google.com/mapfiles/ms/micons/red.png";

// The init method called by google maps
function initMap() {
    var ele = $(".map")[0];
    var markers = [];

    // The lat and lon of Capgemini Utrecht
    var maps = new google.maps.Map(ele, {
        center: {lat: 52.099840, lng: 5.064970},
        zoom: 4
    });

    URLUtil.get("/api/airport/").then(function(arr) {
        $.each(arr, function(i, obj) {
            var pos = {lat: obj.latitude, lng: obj.longitude};
            createMarker(pos, obj.name, maps);
        });
    });

    // Shifts the array and toggles the markers to the correct colors
    function shiftMarkers(markers) {
        var og = markers.shift();

        og.setIcon(DEFAULT_ICON);

        return markers;
    }

    // Create a new marker at the given position and add it to the markers array
    function createMarker(pos, name, map) {
        var marker = new google.maps.Marker({
            position: pos,
            map: map,
            icon: DEFAULT_ICON,
            name: name
        });

        // When the user clicks a marker, check if this is the first marker
        // if that's the case make this the starting point.
        // If it's the second marker, make it the ending point.
        // If it's above the second marker, shift everything
        marker.addListener("click", function(e) {
            markers.push(marker);

            if(markers.length > 2) {
                markers = shiftMarkers(markers);
            }



            updateInfo();

            console.log("Markers:", markers);
        });


        return marker;
    }

    // Updates the info of the markers array
    // Firstly, set the correct icons
    // Secondly, update the text fields with the correct airport names
    function updateInfo() {
        markers[0].setIcon(FIRST_ICON);
        if (markers.length > 1) {
            markers[1].setIcon(SECOND_ICON);
        }

        $(".airport .first").html(markers[0].name);
        $(".airport .second").html(markers[1].name);

    }
}