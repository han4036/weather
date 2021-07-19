<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
  <link rel="stylesheet" href="/resources/css/chart.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ${row}
        ]);
        
	        var options = {
	          title: '시간별 ${cate}',
	          legend: { position: 'bottom' },
	          hAxis: {
	              title: 'Time',
	              showTextEvery: 4,
	              textStyle: {
	                  color: '#2B2B2B',
	                  fontSize: 15,
	              },
	              titleTextStyle: {
	                  color: '#2B2B2B',
	                  fontSize: 20,
	                  fontName: 'Arial',
	                  bold: false
	              }
	          }
	        };
        
        
        
        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }

    </script>
  </head>
  <body>
   <script>
   $(function() {
	   console.log('${cate}');
      $("#date1").datepicker({
    	dateFormat: 'yy-mm-dd',
    	showMonthAfterYear: true,
    	showOtherMonths: true,
        changeMonth: false,
        changeYear: false,
        showOn: "both",
        buttonImage: "/resources/Img/images1.png",
        buttonImageOnly: true,
        yearSuffix: "년",
        nextText: '다음 달',
        prevText: '이전 달',
        dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        minDate: "-1Y",
        maxDate: "+1Y"
      });
      
    })
    </script>
    <div>
	    <form action="/chart/chart2" method="get" id="chart2">
	    <i class="input-group-addon"></i>
	      <input type="text" name="date" id="date1" readonly value="${date }">

        
          <select name="category" id="cate">
            <option value="온도" selected>온도</option>
            <option value="습도">습도</option>
          </select>
        
	      <div>
	        <button type="submit" id="submit">조회</button>
	      </div>
	
	    </form>
	  
	    <div id="curve_chart" style="width: 900px; height: 600px"></div>
    </div>
    <script>
     
    </script>
  </body>
</html>