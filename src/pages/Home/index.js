import PaginaInicial from '../../components/TelaInicial';
import './styles.css';

function HomePage() {
  return (
    <>
      <div className="fundo-tela"></div>  {/* fundo fixo com imagem */}
      <div className="home">
        <PaginaInicial />
      </div>
    </>
  );
}

export default HomePage;
