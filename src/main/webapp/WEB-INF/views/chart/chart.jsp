<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/home.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<link rel="stylesheet" type="text/css" href="/resources/src/css/jquery-ui.css">"
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<meta charset="UTF-8">
<title>weather.jsp</title>

    
<script>
 
</script>
</head>
<body>
     <script>
   $(function() {
      $("#date1").datepicker({
        dateFormat: 'yy-mm-dd',
        showMonthAfterYear: true,
        showOtherMonths: true,
        changeMonth: false,
        changeYear: false,
        showOn: "both",
        buttonImage: "../resources/Img/images1.png",
        buttonImageOnly: true,
        yearSuffix: "년",
        nextText: '다음 달',
        prevText: '이전 달',
        dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7', '8월', '9월', '10월', '11월', '12월'],
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        minDate: "-1Y",
        maxDate: "+1Y",
        setDate: 'today'
      });
      $('#date1').datepicker('setDate', 'today');
      
    })
    </script>
    <div id="wrapper">
      <div id="text">
        <h2>날씨 예보(온도/습도) 조회하기</h2>
      </div>
	    <div id="weather">
		    <form action="/chart/chart2" method="get" id="chart2">
		    <label for="date1">날짜선택</label>
		      <input type="text" name="date" id="date1">
		      
		      <select name="category" id="cate">
		        <option value="온도">온도</option>
		        <option value="습도">습도</option>
		      </select>
		      
		      <div id=sub-btn>
		        <button type="submit" id="submit">조회</button>
		      </div>
		    </form>
        </div>
    </div>
</body>
</html>


