let searchBtnEl = document.getElementById("searchBtn");

function searchWeatherReport(){
    const searchResultsEl = document.getElementById("searchResults");
    searchResultsEl.classList.add("d-block","d-flex","flex-row");
	var inputVal = document.getElementById("userInput").value;
	let url = "https://api.openweathermap.org/data/2.5/forecast?q="+inputVal+"&appid=2f1abe97d17a1607212d21d475af2c77";	
	let options = {
		method: "GET"
	};

	fetch(url , options)
	.then(function(response){
		return response.text();
	})
		
	.then(function(text){
		var data = JSON.parse(text)
		console.log(data);
		return data;


		document.getElementById("tempMin1").textContent = data.list[0].main.temp_min;

	});
	
	document.getElementById("tempMin1").textContent = "yy";



}


