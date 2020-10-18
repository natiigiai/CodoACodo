for (var i = 11; i >= 9; i--) {
	document.write("<h2>La tabla del "+i+"</h2>");
	document.write('<ol class="list-group">');
	for (var j = 1; j <= 9; j++) {
		document.write('<li class="list-group-item">'+i+' x '+j+' = '+i*j+'</li>');
	}
	document.write('</ol>');
}