var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#messages").html("");
}

function connect() {
    var socket = new SockJS('/chat-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat', function (message) {
            var json = JSON.parse(message.body);
            showMessage(json.name, json.message);
        });
        stompClient.subscribe('/app/connect', function (messages) {
            console.log(messages.body);
            var allMessages = JSON.parse(messages.body);
            console.log(allMessages);
            for (var i = 0; i < allMessages.length; ++i) {
                var json = allMessages[i];
                showMessage(json.name, json.message);
            }
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/send", {},
                     JSON.stringify({'name': $("#name").val(),
                                     'message' : $("#message").val()
                                    }));
}

function showMessage(name, message) {
    $("#messages").append("<tr><td><strong>" + name + "</strong> : " + message + "</td></tr>");
}

$(function () {
    $("#conversation").hide();
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

