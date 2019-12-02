window.OTG = window.OTG || {};
window.OTG.dashboard = window.OTG.dashboard || {};
window.OTG.dashboard.db = $.extend(true,
    window.OTG.dashboard.db,
    (function($) {
        "use strict";
        var vm = {};
        var option;
        var defaultOption = {
            form: null
        };
        var token;

        var createViewModel = function() {

        vm.Usercard=ko.observableArray([]);


          var urltocall="http://localhost:8080/api/card/GetLinkcards/1"
          var headertoken="Bearer " + token;


   $.ajax({
       "crossDomain": true,
            url: "http://localhost:8080/api/card/GetLinkcards/1",
            type: 'GET',
            "headers": {  "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaWRoaW5AZ21haWwuY29tIiwiZXhwIjoxNTc0MjM0ODA3LCJpYXQiOjE1NzQxOTg4MDd9.TygtX-C2QKhi6WAejqRykQ6-fPjJUB7KGjhJtCAlSMg",
    "Accept": "*/*",
    "Cache-Control": "no-cache",
    "cache-control": "no-cache"},
            contentType: 'application/json; charset=utf-8',
            success: function(result){
              vm.Usercard(result);
              },
              error: function(XMLHttpRequest, textStatus, errorThrown) {
                  alert("Status: " + textStatus);
                  alert("Error: " + errorThrown);
              }
            });


      }
           var init = function(opt) {
            option = opt || defaultOption;
            var username="username";
            token = getCookie(username);
            createViewModel();
            ko.applyBindings(vm, option.form);
        };

        return {
            init: init,
            model: vm
        };

    }(jQuery || $)));
