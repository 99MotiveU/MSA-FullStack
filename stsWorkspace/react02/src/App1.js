import {marked} from 'marked'; // 35.9K (11.2K gzipped)
import { useEffect, useState } from 'react';
import sanitizeHtml from 'sanitize-html'; // 206K (63.3K gzipped)

function App1({page}) {
  const [content, setContent] = useState('');
  // NOTE: loads *after* first page render.
  useEffect(() => {
    console.log(1);
    // fetch(`/api/content/${page}`).then((data) => {
    //     setContent(data.content);
    // });
    // (async()=>{
    // const content = await file.readFile(`${page}.md`);
    // setContent(content);
    // })();
    console.log(2);
  }, [page]);
  
  return <div>{console.log(0)}{sanitizeHtml(marked(`
# Header1
content
## Header2
  - content1
  - content2
  - content3
  - content4
    
    `))}</div>;
}
export default App1;