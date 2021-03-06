// The main file is meant to construct the dataTable and provide a global variable for other javascript files to use
var DATA_TABLE;
var BASE_URL = "/api/type/";
var BRAND_URL = "/api/brand/";
var DATA_PAIRS = {
    id: ".id",
    name: ".name",
    brand: ".brand"
};


$(function() {
    DATA_TABLE = $("table").DataTable({
        columns: [
            {data: "id"},
            {data: "name"},
            {data: "brand.name"},
            {
                data: null,
                className: "center",
                defaultContent: '<a href="edit"><i class="fas fa-edit"></i></a> / <a href="delete"><i class="far fa-trash-alt"></i></a>'
            }
        ]
    });
});