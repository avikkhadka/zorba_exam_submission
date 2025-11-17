$(document).ready(function() {
    $("#passengerForm").submit(function(event) {
        event.preventDefault();

        $(".error").text("");


        var name = $("input[name='passengerName']").val().trim();
        var email = $("input[name='passengerEmail']").val().trim();
        var mobile = $("input[name='passengerMobile']").val().trim();
        var address = $("input[name='passengerAddress']").val().trim();
        var username = $("input[name='passengerUsername']").val().trim();
        var password = $("input[name='passengerPassword']").val().trim();

        var valid = true;

        if (!name) {
            $("#nameError").text("Please provide your name.");
            valid = false;
        }
        if (!email) {
            $("#emailError").text("Please provide your email.");
            valid = false;
        } else if (!email.includes("@") || !email.endsWith("gmail.com")) {
            $("#emailError").text("Provide valid email address.");
            valid = false;
        }
        if (!mobile) {
            $("#mobileError").text("Please provide your mobile number.");
            valid = false;
        }
        if (!address) {
            $("#addressError").text("Please provide your address.");
            valid = false;
        }
        if (!username) {
            $("#usernameError").text("Please provide a username.");
            valid = false;
        }
        if (!password) {
            $("#passwordError").text("Please provide a password.");
            valid = false;
        } else if (password.length < 8 || password.length > 15) {
            $("#passwordError").text("Password must be 8-15 characters.");
            valid = false;
        }

        if (!valid) return;


        var formData = {
            passengerName: name,
            passengerEmail: email,
            passengerMobile: mobile,
            passengerAddress: address,
            passengerUsername: username,
            passengerPassword: password
        };

        $.ajax({
            url: '<c:url value="/passenger/savePassengerInfo"/>',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                alert(response.message);
                $("#passengerForm")[0].reset();
            },
            error: function(xhr) {
                alert("Error occurred while registering: " + xhr.responseText);
            }
        });
    });
});
