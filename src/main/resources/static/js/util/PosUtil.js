var PosUtil = {};

// Taken from: https://www.movable-type.co.uk/scripts/latlong.html
PosUtil.getDistance = function(pos1, pos2) {
    var R = 6371e3; // metres
    var r1 = PosUtil.toRadians(pos1.lat());
    var r2 = PosUtil.toRadians(pos2.lat());
    var dr = PosUtil.toRadians(pos2.lat()-pos1.lat());
    var dd = PosUtil.toRadians(pos2.lng()-pos1.lng());

    var a = Math.sin(dr/2) * Math.sin(dr/2) +
        Math.cos(r1) * Math.cos(r2) *
        Math.sin(dd/2) * Math.sin(dd/2);
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    return Math.round((R * c) / 1000);
};

PosUtil.toRadians = function(val) {
    return val * (Math.PI / 180);
};

PosUtil.convertLatLng = function(pos) {
    return {
        latitude: pos.lat(),
        longitude: pos.lng()
    }
};