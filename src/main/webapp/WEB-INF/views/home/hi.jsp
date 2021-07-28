<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    
<!--    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>   -->
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
       <script type="text/javascript">
        var searchResultColNames = ['구분', '온도'];
        var searchResultColModel = [{name: '00:00', index:'t00'}]

        var gridData = ${sb};
        var gridData2 = ajaxName;
        
//         $(function(){
//             $("#list").jqGrid({
//                 datatype: "local",
//                 height: 250,
//                 colNames:['구분', '온도'],
//                 colModel:[
//                 	   {name:'구분', index:'구분', align:'center', hidden: false},
//                 	   {name:'온도', index:'온도', align:'center', hidden:false},
//                 ],
//                 caption: ""
//             });
            
            
//             for(var i=0; i<gridData.length; i++){
//             	$("#list").jqGrid('addRowData', i+1, gridData[i]);
//             }
//         })

//     var day = $("#category").val();
//     var cat = $("#date").val();
    var queryString = $("#chart3").serialize();
    var form = $("#chart3")[0];
    var data2 = new FormData(form)
    var ajaxName;

    $(function() {
    	var dte = new Date();
        console.log(dte);
    	
    	$("#list").jqGrid({
            datatype: "local",
            height: 250,
            colNames:['구분', '온도'],
            colModel:[
                   {name:'구분', index:'구분', align:'center', hidden: false},
                   {name:'온도', index:'온도', align:'center', hidden:false},
            ],
            caption: ""
        });
        
        
        for(var i=0; i<gridData.length; i++){
            $("#list").jqGrid('addRowData', i+1, gridData[i]);
        }
    	 $("#date").change(function() {
    		 var day = $("#date").val();
    		 var cate = $("#category").val();
	             $.ajax({
	            	 processData: false,
	                 type: 'post',
	                 aync: false,
	                 url:'/chart/chart3',
	                 data: {'date' : day, 'category':cate},
	                 dataType:'json',
	                 contentType: 'application/json; charset:UTF-8',
	                 success: function(data){
	                	 ajaxName = JSON.stringify(data);
	                	 
// 	                	 for(var i=0; i<gridData.length; i++){
// 	                       $("#list").jqGrid('addRowData', i+1, gridData[i]);
// 	                      }
	                	 
// 	                	 ajaxName = JSON.stringify(data);
// 	                	 console.log(gridData);
// 	                	 console.log(gridData2);
	                	 
	                    
	                     $('#dd').text(ajaxName);
	                     console.log(${date});
	                 },
	                 error: function(e){
	                     alert('실패');
	                     console.log(e);
	                 }
	             });
         })
         
         $("#date").datepicker({
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
           $('#date').datepicker('setDate', 'today');
           
        
    });
   

        </script>
        <meta charset="UTF-8">
        <title>Insert title here</title>
<!--         <style>
/*         #gview_list { */
/*             border: 1px solid black; */
/*         } */
         </style> -->
    </head>

    <body>
    
    <div id="weather">
            <form action="/chart/chart3" method="post" id="chart3">
            <label for="date1">날짜선택</label>
              <input type="text" name="date" id="date">
              
              <select name="category" id="category">
                <option value="온도" selected>온도</option>
                <option value="습도">습도</option>
              </select>
              
              <div id=sub-btn>
                <button type="submit" id="submit">조회</button>
              </div>
            </form>
        </div>
        
        <table id="list"></table>

<!--         <table id="list"></table> -->


    </body>

    </html>