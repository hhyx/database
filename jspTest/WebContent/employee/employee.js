$(function() {
  var flag = 0;

  $(document).ready(function() {
    $(".btn").click(change);

    $(".SpecialCharacter").click(function() {
      // window.location = '../login/login.jsp';
      window.location = '../login/login.html';
    });

  });

  function change(e) {
    if ($(this).attr('id') == "1") {            //点击“我的面试”
      if ($(".MyInterview").hasClass("hide")) {
        $(".MyInterview").removeClass("hide");
      }
      if ($(".MyApplication").hasClass("show")) {
        $(".MyApplication").removeClass("show");
      }
      if ($(".CompanyList").hasClass("show")) {
        $(".CompanyList").removeClass("show");
      }

      $(".MyInterview").addClass("show");
      $(".MyApplication").addClass("hide");
      $(".CompanyList").addClass("hide");

      if ($("#2").hasClass("chosen")) {
        $("#2").removeClass("chosen");
      }
      if ($("#3").hasClass("chosen")) {
        $("#3").removeClass("chosen");
      }
      $("#1").addClass("chosen");
    } else if ($(this).attr('id') == "2") {           //点击“我的申请”
      if ($(".MyInterview").hasClass("show")) {
        $(".MyInterview").removeClass("show");
      }
      if ($(".MyApplication").hasClass("hide")) {
        $(".MyApplication").removeClass("hide");
      }
      if ($(".CompanyList").hasClass("show")) {
        $(".CompanyList").removeClass("show");
      }

      $(".MyInterview").addClass("hide");
      $(".MyApplication").addClass("show");
      $(".CompanyList").addClass("hide");

      if ($("#1").hasClass("chosen")) {
        $("#1").removeClass("chosen");
      }
      if ($("#3").hasClass("chosen")) {
        $("#3").removeClass("chosen");
      }
      $("#2").addClass("chosen");
    } else if ($(this).attr('id') == "3") {           //点击“公司”
      if ($(".CompanyList").hasClass("hide")) {
        $(".CompanyList").removeClass("hide");
        $(".CompanyList").addClass("show")

        if ($("#1").hasClass("chosen")) {
          $("#1").removeClass("chosen");
          flag = $("#1");
        }
        if ($("#2").hasClass("chosen")) {
          $("#2").removeClass("chosen");
          flag = $("#2");
        }
        $("#3").addClass("chosen");
      } else if ($(".CompanyList").hasClass("show")) {
        $(".CompanyList").removeClass("show");
        $(".CompanyList").addClass("hide");

        flag.addClass("chosen");
        $("#3").removeClass("chosen");
      }
    }
  }

});