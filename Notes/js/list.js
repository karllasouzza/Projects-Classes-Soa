$("#notes").ready(() => {
  $.ajax({
    url: "http://localhost:9000/wsnotes/list",
    type: "GET",
    success: (res) => {
      console.log(res);

      $("#notes").html(
        res.map(
          (item) =>
            `
<a href="./Insert.html?id=${item.id}" class="list-group-item list-group-item-action" aria-current="true">
<div class="d-flex w-100 justify-content-between">
  <h5 class="mb-1">${item.title}</h5>
  <small>3 days ago</small>
</div>
<p class="mb-1"></p>
<small>${item.content}</small>
</a>

`
        )
      );
    },
    error: (response) => {
      console.log(response);
    },
  });
});
