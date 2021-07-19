<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ${row}
        ]);

        var options = {
          title: '시간별 온도',
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
    <div id="curve_chart" style="width: 900px; height: 600px"></div>
    
  </body>
</html>