/*jslint browser: true */
/*global $, console, prompt */

$(document).ready(function () {
    "use strict";
    $(".title").mouseenter(function () {
        $(".title").fadeTo("fast", 1.0);
    });
    $(".title").mouseleave(function () {
        $(".title").fadeTo("medium", 0.9);
    });
});

var orangeCost = function (orangeCost) {
    "use strict";
    console.log(orangeCost * 5);
};

orangeCost(2);