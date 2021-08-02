<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/chart.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="/resources/css/ui.jqgrid.css" type="text/css">
<link rel="stylesheet" href="/resources/src/css/jquery-ui.css" type="text/css">


<script type="text/javascript" src="/resources/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript" src="/resources/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="/resources/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery.jqGrid.src.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/5.5.5/js/jquery.jqGrid.min.js"></script>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.6.0/jszip.min.js"></script>
	
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>



<script type="text/javascript">
      
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      var data2 = [${chartRow}];
      var cate1 = '${cate}';

        
      // 구글차트 그리는 함수
      function drawChart() {
    	  
    	  var chart_data = google.visualization.arrayToDataTable(
              data2
          ); 
        
        var options = {
              title: '시간별 '+cate1,
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
      }; // drawChart
      
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


 
   var formatter2 = function(cellValue, options, rowObject) {
	   if(cellValue == null || cellValue === 'null') {
		   cellValue = '0';
	   }
	   return cellValue;
   }
    
    var cate1 = "${cate}";
    var colNam = ['sid','구분',${colName}];
    
    $(function(){
    	var date1 = $("#date1").val();
    	console.log(date1);
    	console.log(cate1);
    	console.log($("#date1").val());
    	var gridData = ${gridRow};
    	
    	// 그리드 그리기
    	gridView(gridData);
    	
    	// 그리드 그리는 함수
    	// gridData = DataController에서 넘겨받은 데이터를 매개변수로 주기위해 gridData에 저장
		function gridView(gridData){
			var dayInfo = $("date1").val();
	// 		$("#list").jqGrid("GridUnload");
			$.jgrid.gridUnload("#list");
		
			$("#list").jqGrid({
		
				url: "/chart3",
	            datatype: "local",
	            width: 700,
	            height: 600,
	            cellEdit: true,
	            cellsubmit: 'remote',
	            cellurl: '/chart/chart4',
	            beforeSubmitCell: function(id, cellname, value) {
	            	console.log(id.sid);
	            	console.log(date1);
	            	return {"id":id, "cellName":cellname, "cellValue":value, "date":date1}
	            },
	            afterSubmitCell: function(res) {
	            	console.log(res);
	                var aResult = res.responseText;
	                var userMsg = "";
	                
	                if((aResult=="success")){
	                    userMsg="데이터가 변경되었습니다.";	
	                alert(userMsg);
	                }
	                return[(aResult == "success") ? true : false,userMsg];
	            
	            },
	//             afterEditCell: function(rowid, cellname, value, iRow, iCol){
	//             	$("#"+rowid+"_"+cellname).blur(function(){
	//             		$("#list").jqGrid("saveCell",iRow,iCol);
	//             		});
	//             	},
	            
	            
	            colNames: colNam,
	            colModel:[
	            	   {name:'sid', index:'sid', hidden:true, key:true},
	                   {name:'구분', index:'구분', align:'center', hidden: false},
	                   {name:cate1, index:cate1, align:'center', hidden:false, editable: true /* formatter: formatter2 */},
	                   ],
	            jsonReader: {
	            	root: '${gridRow}',
	                repeatitems:false,
	            },
	            loadonce: false,
	            caption: ""
	        });
			
			  // for문으로 그리드에 데이터 그리기
			for(var i=0; i<gridData.length; i++){
	            
	            $("#list").jqGrid('addRowData', i+1, gridData[i]);
	        }
			
			
			  // 현재 그리드에 표현되어 있는 데이터만 다운로드 가능
			$("#export_Excel").on("click", function(){
				 $("#list").jqGrid("exportToExcel", {
		            includeLabels: true,
		            includeGroupHeader: true,
		            includeFooter: true,
		            excelstyles:['text-align'],
		            fileName:date1+" "+cate1+ "데이터.xlsx",
		        });
			});
	
		
		// 적용X
// 	    $("#list").jqGrid('navButtonAdd', '#list2_table_nav', 
// 			{
// 				caption:"Excel 출력", 
// 				title: "Excel 출력",
// 				id: 'pager_excel',
// 				onClickButton:function(e){
// 				    alert("새로만튼 버튼 클릭");
// 				    exportExcel($("#list"), "test.xls");
//         },buttonicon : 'ui-icon-disk'
  
//       });
		
	} // function gridView
	
	
	    // 온/습도 카테고리 변경시 일어나는 이벤트(선택한 카테고리에따라 선택한 온/습도 값 조회 이벤트)
		$("#cate").change(function(){
			date1 = $("#date1").val();
			cate1 = $("#cate").val();
			colNam = ['sid','구분', cate1];
			console.log("cate1 : " + cate1);
			$.ajax({
                type: "post",
                url: "/chart/chart3",
                loadonce: false,
                async: true,
                data : {'date': date1, 'category' : cate1},
                dateType: "application/json; charset:UTF-8",
                success: function(result) {
                	$("#list").jqGrid('clearGridData');
                	
                    gridData = result.grid;
                    
                    var colNames = $("#list").jqGrid('getGridParam', 'colNames');
                    var colModel = $("#list").jqGrid('getGridParam', 'colModel');
                    
                    console.log("colNames : "+colNames);
                    console.log("colModel : "+colModel);
                    
                    var change1 = colModel[2].name;
                    
                    $("#list").jqGrid("setLabel", change1, cate1);
                    
                    colNames = $("#list").jqGrid('getGridParam', 'colNames');
                    colModel = $("#list").jqGrid('getGridParam', 'colModel');
                    
                    console.log("colNames : "+colNames);
                    console.log("colModel : "+colModel);
                    $("#list").jqGrid('clearGridData');
                    
                    gridView(gridData);
                    
                    data2 = eval("["+result.chart+"]");
                    
                    drawChart();
                    
                },
                error: function(result){
                	alert('해당 날짜의 데이터가 없습니다.\n 다른 날짜를 선택해주세요.');
                }
		
			})
		});
		
		// 날짜 변경시 일어나는 이벤트(선택한 특정 날짜에 따른 온/습도값 조회 이벤트)
	    $("#date1").change(function(){
	    	date1 = $("#date1").val();
	    	cate1 = $("#cate").val();
	    	$.ajax({
	    		type: "post",
	    		url: "/chart/chart3",
	    		loadonce: false,
	    		async: true,
	    		data : {'date': date1, 'category' : cate1},
	    		dateType: "application/json; charset:UTF-8",
	    	    success: function(result) {
	    	    	
	    	    	$("#list").jqGrid('clearGridData');
	    	    	
	    	    	gridData = result.grid;
                    console.log(typeof ('['+result.chart+']'));
                    data2 = eval("["+result.chart+"]");
                    
                    drawChart();
                    
	    	    	for(var i=0; i<gridData.length; i++){
	    	            
	    	            $("#list").jqGrid('addRowData', i+1, gridData[i]);
	    	        } // for
	    	    	
	    	    	
	    	    	
	    	    	console.log(gridData);
	    	    	console.log(typeof gridData);
	    	    	
	    	    }, // success
	    	    
	    	    error : function(e){
	    	    	alert('해당 날짜의 데이터가 없습니다.\n 다른 날짜를 선택해주세요.');
	    	    } // error
	    	}) // ajax(날짜변경시 실행)
	        
	        
	    }) // date1.change
       
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
			
			<div id="weather_table_nav">
			     <button id="export_Excel">Download to Excel</button>
			</div>
		</div>
		<div id="list_div">
	       <table id="list"></table>
		</div>
		<div id="table_nav"></div>

		<div id="curve_chart"></div>
	</div>
	
</body>
</html>