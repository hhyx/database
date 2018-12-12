$(function() {
  var stateList = 0;
  $(document).ready(function() {
    $(".btn").click(change);

    $(".SpecialCharacter").click(function() {
      // window.location = '../login/login.jsp';
      window.location = '../login/login.html';
    });


    stateList = $(".state");
    judgeState(stateList);
    
  });

  function change(e) {
    if ($(this).attr('id') == "1") {
      if ($(".InterviewList").hasClass("hide")) {
        $(".InterviewList").removeClass("hide");
      }
      if ($(".application").hasClass("show")) {
        $(".application").removeClass("show");
      }
      $(".InterviewList").addClass("show");
      $(".application").addClass("hide");
      $("#1").addClass("chosen");
      $("#2").removeClass("chosen");
    } else if ($(this).attr('id') == "2") {
      if ($(".InterviewList").hasClass("show")) {
        $(".InterviewList").removeClass("show");
      }
      if ($(".application").hasClass("hide")) {
        $(".application").removeClass("hide");
      }
      $(".InterviewList").addClass("hide");
      $(".application").addClass("show");
      $("#2").addClass("chosen");
      $("#1").removeClass("chosen");
    }
  }

  function judgeState(stateList) {
    for (var i = 0; i < stateList.length; i++) {
      if (stateList[i].innerHTML != "Waiting") {
        stateList[i].parentNode.className = "row hide";
      }
    }
  }

});