import { BrowserRouter,Routes,Route } from 'react-router-dom';
import Home from './pages/Home';
import Blogs from './pages/Blogs';
import Contact from './pages/Contact';
import './App.css';
import Layout from './pages/Layout';
import AddBlog from './pages/AddBlog';
 
function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route element={<Layout/>}>
            <Route index element={<Home />} />
            <Route path="/blogs/" element={<Blogs />} />
            <Route path="/blogs/add" element={<AddBlog />} />
            <Route path="/contact" element={<Contact />} />
          </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
