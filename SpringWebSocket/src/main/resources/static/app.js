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
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/ws');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/greetings', function(message) {
			handleTopicMessage('/topic/greetings', message);
		});
		stompClient.subscribe('/topic/new-folder', function(message) {
			handleTopicMessage('/topic/new-folder', message);
	});
	});
}

function handleTopicMessage(topic, message) {
	if (topic === '/topic/greetings') {
		showGreeting(JSON.parse(message.body).content);
	} else if (topic === '/topic/new-folder') {
		showGreeting(message.body);
	}
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function showGreeting(message) {
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function sendName() {
	stompClient.send("/app/hello", {}, JSON.stringify({
		'name': $("#name").val()
	}));
}


$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() { connect(); });
	$("#disconnect").click(function() { disconnect(); });
	$("#send").click(function() { sendName(); });
});