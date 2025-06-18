app.get(`/api/content/:page`, async (req, res) => {
  const page = 'README';//req.params.page;
  const content = await file.readFile(`${page}.md`);
  console.log(page,content);
  res.send({content});
});