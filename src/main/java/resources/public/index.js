
function createBook (book) {
    return $('<option>').text(book.name).val(book.id);
}

$(document).ready(function () {
    $('#js-content').css('display', 'block');
    $('form').css('display', 'none');


    $.get({
        url : '/book/list'
    }).then(function (books) {
        books.forEach(function (book) {
            $('#book-list').append(createBook(book));
        });
    });

    $('#book-create').click(function () {
        $.post({
            url         : '/book/create',
            data        : { name : $('#book-name').val() },
            dataType    : 'json'
        }).then(function (book) {
            $('#book-list').append(createBook(book));
        });
    });

    $('#book-view').click(function () {
        window.location.href = '/form/book/view?bookId=' + $('#book-list').val();
    });

});
