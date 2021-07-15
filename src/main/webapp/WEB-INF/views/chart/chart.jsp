<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>weather.jsp</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('visualization','1',{
    'packages' : ['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var jsonData = $.ajax({ //비동기적 방식으로 호출한다는 의미이다.
            url : "${path}/api/weather2",

            //chart01에서는 json의 주소를 직접 적었지만 이 페이지에서는 컨트롤러로 이동해 맵핑해서 제이슨을 동적으로
            //직접만들어 그 만든 json을 직접 보낸다.
            
            
            
            
            //chart01에서 쓰던 방식 url : "${path}/json/sampleData.json",
            //json에 sampleData.json파일을 불러온다.
            //확장자가 json이면 url 맵핑을 꼭 해주어야 한다. 안해주면 자바파일인줄 알고 404에러가 발생한다.
            //그렇기 때문에 servlet-context파일에서 리소스를 맵핑해준다.
            dataType : "json",
            async : false
        }).responseText; //제이슨파일을 text파일로 읽어들인다는 뜻
        console.log(jsonData);
        //데이터테이블 생성
        var data
        = new google.visualization.DataTable(jsonData);
        //제이슨 형식을 구글의 테이블 형식으로 바꿔주기 위해서 집어넣음
        //차트를 출력할 div
        //LineChart, ColumnChart, PieChart에 따라서 차트의 형식이 바뀐다.
        
        //var chart = new google.visualization.PieChart(
                //document.getElementByld('chart_div')); //원형 그래프
        
        var chart
         = new google.visualization.LineChart(
                document.getElementById('chart_div')); //선 그래프 
                
        //var chart
        //  = new google.visualization.ColumnChart(document.getElementById('chart_div'));
                //차트 객체.draw(데이터 테이블, 옵션) //막대그래프
                
                //cuveType : "function" => 곡선처리
                
                //데이터를 가지고 (타이틀, 높이, 너비) 차트를 그린다.
                chart.draw(data, {
                    title : "장바구니 통계",
                    curveType : "function", //curveType는 차트의 모양이 곡선으로 바뀐다는 뜻
                    width : 600,
                    height : 400
                });
    }
 
</script>
</head>
<body>
    
    <!-- 차트 출력 영역 -->
    <div id="chart_div"></div>
    <!-- 차트가 그려지는 영역 -->
    <!-- 차트 새로고침 버튼 -->
    <button id="btn" type="button" onclick="drawChart()">refresh</button>
</body>
</html>


