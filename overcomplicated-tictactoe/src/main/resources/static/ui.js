function placeX() {
    var field = $('.square');
    field.on('click', function() {
        var specField = $(this);
        specField.append('<p> Hello </p>');
    })
}

function main() {
    placeX();
}

$(document).ready(main);