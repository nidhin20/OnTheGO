window.OTG = window.OTG || {};
window.OTG.login = window.OTG.login || {};
window.OTG.login.lg = $.extend(true,
    window.OTG.login.lg,
    (function($) {
        "use strict";
        var vm = {};
        var option;
        var defaultOption = {
            form: null
        };


        function Profileviewmodel() {
             email: ko.observable(),
            password: ko.observable()

        }


        var createViewModel = function() {

        vm.UserProfile=new Profileviewmodel();
    vm.submitform= function()
        {
          var userlogin={
            email: vm.UserProfile.email(),
            password: vm.UserProfile.password()

          }
        $.ajax({
            url: 'http://localhost:8080/authenticate',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data:JSON.stringify(userlogin),
            success: function(result){
              var username="username";
              setCookie(username,result,1);
                       window.location.href="/dashboard";
                   },
                   error: function(XMLHttpRequest, textStatus, errorThrown) {
                       alert(XMLHttpRequest.responseJSON.message);
                   }
        });
        }

        }
           var init = function(opt) {
            option = opt || defaultOption;

            createViewModel();
            ko.applyBindings(vm, option.form);
        };

        return {
            init: init,
            model: vm
        };

    }(jQuery || $)));
