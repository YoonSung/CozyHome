function countComments() {
	var commentList = document.querySelectorAll('#commentBox');
	console.log(commentList);
	
	for (var i = 0 ; i < commentList.length ; i++) {
		var currentBox = commentList[i];
		var currentListCount = currentBox.querySelectorAll(".showComment").length;
		
		currentBox.querySelector(".commentNum").innerText = "댓글개수 : "+currentListCount;
	}
}

function initPage() {
	countComments();
	registerEvents();
}

function registerEvents() {
	var eventList = document.getElementsByClassName("commentControl")
	
	for ( var i = 0 ; i < eventList.length ; i++ ) {
		eventList[i].addEventListener('click', toggleComment, false);
	}
	
	
	var formList = document.querySelectorAll('.commentWrite input[type=submit]');
	
	console.log(formList.length);
	for ( var j = 0 ; j < formList.length ; j++) {
		formList[j].addEventListener('click', writeComment, false);
	}
}

function toggleComment(event) {
	var target = event.target.parentNode.nextElementSibling;
	target.style.display="block";
	//target.setAttribute("display", "block")
}


function writeComment(event) {
	event.preventDefault();
	
	var eleForm = event.currentTarget.form // form element
	var oFormData = new FormData(eleForm);
	
	var sID = eleForm[0].value;
	var url = "/board/commentJson/"+sID;
	
	var request = new XMLHttpRequest();
	
	request.open("POST", url, true);
	request.send(oFormData);
}

window.onload = initPage;