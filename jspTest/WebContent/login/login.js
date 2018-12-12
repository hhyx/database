(function() {
    
    window.onload = function() {
      wrapper = document.getElementsByClassName("sm2")[0];
      wrapper2 = document.getElementsByClassName("sm1")[0];
      wrapper3 = document.getElementsByClassName("sm3")[0];
      wrapper.addEventListener("mouseover", change1);
      wrapper.addEventListener("mouseout", change2);
      wrapper.addEventListener("mousedown", change3);
      wrapper.addEventListener("mouseup", change4);
      wrapper2.addEventListener("mouseover", change12);
      wrapper2.addEventListener("mouseout", change22);
      wrapper2.addEventListener("mousedown", change32);
      wrapper2.addEventListener("mouseup", change42);
      wrapper3.addEventListener("mouseover", change);
      wrapper3.addEventListener("mouseout", ori);
      wrapper3.addEventListener("mousedown", changesma);
    };
    function change1() {
      document.getElementsByClassName("sm2")[0].className = "mb";
    }

    function change2() {
      document.getElementsByClassName("mb")[0].className = "sm2";
    }

    function change3() {
      document.getElementsByClassName("mb")[0].className = "cb";
      document.getElementsByName("res")[0].className = "cb";
    }

    function change4() {
      document.getElementsByName("res")[0].className = "mb";
    }

    function change12() {
      document.getElementsByClassName("sm1")[0].className = "mb2";
    }

    function change22() {
      document.getElementsByName("subm")[0].className = "sm1";
    }

    function change32() {
      document.getElementsByName("subm")[0].className = "cb2";
      document.getElementsByName("subm")[0].className = "cb2";
    }

    function change42() {
      document.getElementsByName("subm")[0].className = "mb2";
    }

    function change() {
      document.getElementsByClassName("sm3")[0].style.borderColor = "#5F6575";
      document.getElementsByClassName("link")[0].style.fontSize = "29px";

    }

    function ori() {
      document.getElementsByClassName("sm3")[0].style.borderColor = "#7F8595";
      document.getElementsByClassName("link")[0].style.fontSize = "27px";

    }

    function changesma() {
      document.getElementsByClassName("link")[0].style.fontSize = "27px";

    }
    

})();