/**
 * Created by Training on 12/3/2015.
 */
//for checking if dom is loaded.. basically checks if dojo is ready to apply functions without this table in which data is to be loaded isnt ready
//$(document).ready(function()
function reverse()
{
	 console.log("reverse currency loaded");
	 currency1= document.getElementById("countryCode");
	 currency2= document.getElementById("countryCode2");
	 curVal1 = currency1.options[currency1.selectedIndex].value;
	 curVal2 = currency2.options[currency2.selectedIndex].value;

	 if(curVal1=="" || curVal2=="")
	 	{
		 alert("CURRENCIES CANT BE NULL..!");
			document.getElementById("currency1value").value="";
			document.getElementById("currency2value").value="";	
	 	}
	 else
		 {
			document.getElementById("currency1").value=curVal2;
			document.getElementById("currency2").value=curVal1;
			
		    var urlString="http://data.fixer.io/api/convert?access_key=a2ccad498829c2ccdd17dcdfb6100242&from=" + curVal2 +"&to=" + curVal1 + "&amount=1&format=1";
		    $.ajax({
			   
			   crossDomain: true,
			    url: urlString,
		        type:'GET',
		        dataType: 'jsonp',
		        
		        success:function(data) {
		        	console.log(data.rates);

		            $.each(data.rates, function (item,value) {
		            	if(item==curVal2)
		            		{
		            		document.getElementById("currency1value").value="1";
		            		document.getElementById("currency2value").value=value;	
		            		}
		            })
		            
		        },
		        failure: function(x)
		        {
		        	console.log("failure it is"+x);
		        }
		        
		   })
		 
		 }
};

function change_C()
{
    console.log("change currency loaded");
currency1= document.getElementById("countryCode");
currency2= document.getElementById("countryCode2");
curVal1 = currency1.options[currency1.selectedIndex].value;
curVal2 = currency2.options[currency2.selectedIndex].value;

if(curVal1== curVal2 || curVal1==null || curVal2==null)
	{
	alert("CURRENCIES CANT BE SAME..!");
	document.getElementById("currency1value").value="";
	document.getElementById("currency2value").value="";	
	}
else
	{	
	document.getElementById("currency1").value=curVal1;
	document.getElementById("currency2").value=curVal2;
    var urlString="http://data.fixer.io/api/convert?access_key=a2ccad498829c2ccdd17dcdfb6100242&from=" + curVal2 +"&to=" + curVal1 + "&amount=1&format=1";
    $.ajax({
	   
	   crossDomain: true,
	    url: urlString,
        type:'GET',
        dataType: 'jsonp',
        
        success:function(data) {
        	console.log(data.rates);

            $.each(data.rates, function (item,value) {
            	if(item==curVal2)
            		{
            		document.getElementById("currency1value").value="1";
            		document.getElementById("currency2value").value=value;	
            		}
            })
            
        },
        failure: function(x)
        {
        	console.log("failure it is"+x);
        }
        
   })
	}
};


