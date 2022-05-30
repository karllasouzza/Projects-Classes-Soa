$("form").submit((e) => {
  e.preventDefault();

  const body = {
    title: $("#title").val(),
    content: $("#content").val(),
  };
  console.log(body);

  $.ajax({
    headers: {
      "Content-Type": "application/json",
    },
    url: "http://localhost:9000/wsnotes/insert",
    type: "POST",
    data: JSON.stringify(body),
    contentType: "application/json",
    dataType: "json",
    success: (response) => {
      console.log(response);
    },
    error: (response) => {
      console.log(response);
    },
  });
});
