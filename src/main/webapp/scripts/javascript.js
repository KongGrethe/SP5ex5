/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#failed").hide();
    loadEvents();

});

function loadEvents() {

    $("#population").click(function () {
        alert("You clicked. Data stackoverflows though..");
        $.ajax({
            url: 'api/country/population/' + $("#popval").val(),
            type: 'GET',
            contentType: 'application/json',
            success: function (entry) {
                $('#person-tbody').append(
                        "<tr>" +
                        "<td class='tabletd'>" + entry.code + "</td>" +
                        "<td class='tabletd'>" + entry.name + "</td>" +
                        "<td class='tabletd'>" + entry.continent + "</td>" +
                        "<td class='tabletd'>" + entry.capital + "</td>" +
                        "</tr>"
                        );
            },
            error: function () {
                $("#failed").show().html("I cannot reach the data unfortunately.");
            }
        });
    });

    $("#city").click(function () {
        alert("You clicked. Data stackoverflows though");
        $.ajax({
            url: 'api/country/city/' + $("#ccode").val(),
            type: 'GET',
            contentType: 'application/data',
            success: function (entry) {
                $('#person-tbody').append(
                        "<tr>" +
                        "<td class='tabletd'>" + entry.name + "</td>" +
                        "<td class='tabletd'>" + entry.code + "</td>" +
                        "<td class='tabletd'>" + entry.district + "</td>" +
                        "<td class='tabletd'>" + entry.population + "</td>" +
                        "</tr>"
                        );
            },
            error: function () {
                $("#failed").show().html("Data is unreachable. status: 500");
            }
        });
    });

}

