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
    <link rel="stylesheet" type="text/css" href="/resources/css/ui.jqgrid.css">
    <link rel="stylesheet" type="text/css" href="/resources/src/css/jquery-ui.css">"
    
    <script type="text/javascript" src="/resources/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/resources/js/i18n/grid.locale-kr.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.jqGrid.src.js"></script>
        
<!--     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/5.5.5/js/jquery.jqGrid.min.js"></script>
    
<!-- 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>   -->
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
//       google.charts.load('current', {'packages':['corechart']});
//       google.charts.setOnLoadCallback(drawChart);
      
    	
//       function drawChart() {
//         var data = google.visualization.arrayToDataTable([
//             ${chartRow}
//         ]);
        
// 	        var options = {
// 	          title: '시간별 ${cate}',
// 	          legend: { position: 'bottom' },
// 	          hAxis: {
// 	              title: 'Time',
// 	              showTextEvery: 4,
// 	              textStyle: {
// 	                  color: '#2B2B2B',
// 	                  fontSize: 15,
// 	              },
// 	              titleTextStyle: {
// 	                  color: '#2B2B2B',
// 	                  fontSize: 20,
// 	                  fontName: 'Arial',
// 	                  bold: false
// 	              }
// 	          }
// 	        };
        
        
        
//         var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

//         chart.draw(data, options);
//       };
      
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      
//       function load_page_data(){
//           $.ajax({
//               url:"/chart/chart3",
//               data:{'date': date1, 'category':cate1},
//               async: false,
//               success: function(data) {
//             	  if(data)
//               }
//           })
//       }

        var data2 = [${chartRow}];

        console.log(typeof ${chartRow});
        
      function drawChart() {
    	  
    	  var chart_data = google.visualization.arrayToDataTable(
              data2
          ); 
        
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

        chart.draw(chart_data, options);
      };
      
      
      
//       function drawInit() {
    	  
//     	  var data = null;
//     	  var table_data = null;
    	  
//     	  $.ajax({
//     		  url:'/chart/chart3',
//     		  data: {'date':date1, 'category': cate1},
//     		  success: function(result) {
//     			  table_data = google.visualization.arrayToDataTable([
//     		            result.chart
//     		            ]);
//     			  drawChart(table_data);
//     		  }
//     	  });
//       }
      
      
      
      
// <script type="text/javascript">
//     var gridData = ${gridRow};
    
//     $(function(){
//         $("#list").jqGrid({
//             datatype: "local",
// //             width: 1000,
// //             height: 608,
//             width: 700,
//             height: 600,
//             colNames:['구분', ${colName}],
//             colModel:[
//                    {name:'구분', index:'구분', align:'center', hidden: false},
//                    {name:${colName}, index:${colName}, align:'center', hidden:false},
//             ],
//             caption: ""
//         });
        
        
//         for(var i=0; i<gridData.length; i++){
//             $("#list").jqGrid('addRowData', i+1, gridData[i]);
//         }
//     });


 
   
    
    
    var cate1 = "${cate}";
    
    $(function(){
    	var date1 = $("#date1").val();
    	console.log(date1);
    	console.log(cate1);
    	console.log($("#date1").val());
    	 var gridData = ${gridRow};
//     	$.ajax({
//             type:'GET',
//             async:false,
//             url:'/char2',
//             datatype:'json',
//             data:{date:date1, category:cate1},
//             sucess: function(data) {
		$("#list").jqGrid({
			url: "/chart3",
// 			url: "/chart2",
            datatype: "local",
            width: 700,
            height: 600,
            colNames:['구분', ${colName}],
            colModel:[
                   {name:'구분', index:'구분', align:'center', hidden: false},
                   {name:${colName}, index:${colName}, align:'center', hidden:false},
                   ],
            jsonReader: {
            	root: '${row}',
            },
            caption: ""
        });
		
		for(var i=0; i<gridData.length; i++){
            
            $("#list").jqGrid('addRowData', i+1, gridData[i]);
        }
		
		
	    $("#date1").change(function(){
	    	date1 = $("#date1").val();
	    	console.log("date1 : " +date1);
	    	console.log("date1 : " + ${date});
	    	$.ajax({
	    		type: "post",
// 	    		type: "get",
	    		url: "/chart/chart3",
// 	    		url: "/chart/chart2",
	    		loadonce: false,
	    		async: true,
	    		data : {'date': date1, 'category' : cate1},
	    		dateType: "application/json; charset:UTF-8",
	    	    success: function(result) {
	    	    	
	    	    	$("#list").jqGrid('clearGridData');
	    	    	gridData = result.grid;
// 	    	    	$("#list").trigger("reloadGrid");
// 	    	    	chartData = google.visualization.arrayToDataTable([
// 	    	            result.chart
// 	    	            ]);
//                     console.log(typeof result.chart);
//                     var eval = (new Function("return"))
                    console.log(typeof ('['+result.chart+']'));
//                     data2 = '['+result.chart+']';
                    data2 = eval("["+result.chart+"]");
//                     console.log((new Function(("["+result.chart+"]"))));
//                     Object(data2);
//                     data2 = (new Function(('return'+"["+result.chart+"]")))
                    
                    drawChart();
                    
                    
//                     var data2ToArray = data2.split('],[');
//                     console.log(">>>>>> Array : " + data2ToArray);
//                     console.log(">>>>>"+data2);
                    
// 	    	    	drawChart();
	    	    	
	    	    	
// 	    	    	google.setOnLoadCallback(drawInit);
	    	    	
	    	    	for(var i=0; i<gridData.length; i++){
	    	            
	    	            $("#list").jqGrid('addRowData', i+1, gridData[i]);
	    	        }
	    	    	
	    	    	
	    	    	
	    	    	console.log(gridData);
	    	    	console.log(typeof gridData);
	    	    	
// 	    	    	console.log(">>>>>>>>" + data)
	    	    	
// 	    	    	console.log(data);
// 	    	    	for(var i=0; i<gridData.length; i++){
	    	    		
// 	                    $("#list").jqGrid('addRowData', i+1, gridData[i]);
// 	                }
// 	    	    	$("#list").trigger("reloadGrid");
	    	    },
	    	    error : function(e){
	    	    	alert('해당 날짜의 데이터가 없습니다.\n 다른 날짜를 선택해주세요.');
	    	    }
	    	})
	        
	        
	    })
       
	});
	

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
        buttonImage: "../resources/Img/images1.png",
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
      $('#date1').datepicker('setDate', '${date}');
    })
    </script>
    <div id=wrapper>
    
      <div id="weather">
	    <form action="/chart/chart3" method="post" id="chart2">
<!-- 	    <form action="/chart/chart2" method="get" id="chart2"> -->
	      <input type="text" name="date" id="date1" readonly value="${date}">

          <select name="category" id="cate">
            <option value="온도" id="selectTmp" selected>온도</option>
            <option value="습도" id="selectReh">습도</option>
          </select>
        
	      <div id="sub-btn">
	        <button type="submit">조회</button>
	      </div>
	
	    </form>
	  </div>
	  <table id="list"></table>
	  
	    <div id="curve_chart"></div>
      </div>
    <script>
     
    </script>
  </body>
</html>