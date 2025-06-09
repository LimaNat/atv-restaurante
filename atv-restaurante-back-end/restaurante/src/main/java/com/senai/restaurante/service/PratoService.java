package com.senai.restaurante.service;

import com.senai.restaurante.exception.NomeJaCadastradoException;
import com.senai.restaurante.repository.PratoRepository;
import jakarta.validation.Valid;
import com.senai.restaurante.model.Prato;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PratoService {
    private PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public Prato salvar(@Valid Prato prato) {
        if (pratoRepository.findByNome(prato.getNome()).isPresent()) {
            throw new NomeJaCadastradoException("Prato já cadastrado.");
        }

        return pratoRepository.save(prato);
    }

    public Prato atualizar(@Valid Prato prato) {
        Prato pratoAtualizar = pratoRepository.findById(prato.getId())
                .orElseThrow(() -> new IllegalArgumentException("Prato não encontrado."));

        pratoAtualizar.setNome(prato.getNome());
        pratoAtualizar.setDescricao(prato.getDescricao());
        pratoAtualizar.setPreco(prato.getPreco());
        pratoAtualizar.setCategoria(prato.getCategoria());
        pratoAtualizar.setDisponibilidade(prato.getDisponibilidade());

        return pratoRepository.save(pratoAtualizar);
    }





    public void excluir(Long id) {
        Prato pratoExcluir = pratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado"));

        pratoRepository.deleteById(pratoExcluir.getId());
    }

    public void carregarCardapioInicial() {
        if (pratoRepository.count() == 0) {
            pratoRepository.saveAll(List.of(
                    new Prato("Ratatouille", "Legumes assados ao molho de tomate com ervas finas", "Principal", 28.90, "https://www.google.com/imgres?q=ratatouille&imgurl=https%3A%2F%2Fwww.kikkoman.pt%2Ffileadmin%2F_processed_%2F1%2F8%2Fcsm_1075-recipe-page-Saffron-scented-Ratatouille_desktop_d3b870df0d.jpg&imgrefurl=https%3A%2F%2Fwww.kikkoman.pt%2Freceitas%2Fdetail%2Fratatouille-com-aroma-de-acafrao&docid=ZuFfa_jxMdHxqM&tbnid=d3suo5ZRPM_yRM&vet=12ahUKEwiL986vq-SNAxVUpZUCHf0wOQMQM3oECBoQAA..i&w=780&h=460&hcb=2&ved=2ahUKEwiL986vq-SNAxVUpZUCHf0wOQMQM3oECBoQAA"),
                    new Prato("Quiche Lorraine", "Torta salgada de queijo, bacon e ovos", "Entrada", 19.90, "https://www.google.com/imgres?q=quiche%20lorraine&imgurl=https%3A%2F%2Fstatic.cordonbleu.edu%2FFiles%2FMediaFile%2F61129.jpg&imgrefurl=https%3A%2F%2Fwww.cordonbleu.edu%2Fnews%2F-receita-quiche-%2Fpt-br&docid=UjFWMse14LAiBM&tbnid=KTBUMjcJQSwKJM&vet=12ahUKEwi2xr2fq-SNAxWXlJUCHYzyEq8QM3oECBwQAA..i&w=750&h=420&hcb=2&ved=2ahUKEwi2xr2fq-SNAxWXlJUCHYzyEq8QM3oECBwQAA"),
                    new Prato("Soupe à l’oignon", "Sopa de cebola gratinada com queijo e pão", "Entrada", 17.90, "https://www.google.com/imgres?q=soupe%20%C3%A0%20l%27oignon&imgurl=https%3A%2F%2Fassets.afcdn.com%2Frecipe%2F20210104%2F116953_w1024h1024c1cx806cy863cxt0cyt382cxb1641cyb1350.jpg&imgrefurl=https%3A%2F%2Fwww.marmiton.org%2Frecettes%2Frecette_soupe-a-l-oignon_10891.aspx&docid=KwtLLgadkuH1WM&tbnid=kPQtBpmlQZZkwM&vet=12ahUKEwi9msGQq-SNAxWErZUCHVepC6EQM3oECGQQAA..i&w=1024&h=1024&hcb=2&itg=1&ved=2ahUKEwi9msGQq-SNAxWErZUCHVepC6EQM3oECGQQAA"),
                    new Prato("Boeuf Bourguignon", "Carne bovina cozida no vinho tinto com legumes", "Principal", 36.90, "https://www.google.com/imgres?q=boeuf%20bourguignon&imgurl=https%3A%2F%2Fwww.minhareceita.com.br%2Fapp%2Fuploads%2F2022%2F01%2Fboeuf-bourguignon-portal-minha-receita.jpg&imgrefurl=https%3A%2F%2Fwww.minhareceita.com.br%2Freceita%2Fboeuf-bourguignon%2F&docid=zU-c9_kxRebsbM&tbnid=DFXBBYRu41araM&vet=12ahUKEwjXkc3-quSNAxWerJUCHXa7A6oQM3oECBcQAA..i&w=1200&h=675&hcb=2&ved=2ahUKEwjXkc3-quSNAxWerJUCHXa7A6oQM3oECBcQAA"),
                    new Prato("Crème Brûlée", "Creme doce com casquinha crocante de açúcar caramelizado", "Sobremesa", 16.00, "https://www.google.com/imgres?q=creme%20brulee&imgurl=https%3A%2F%2Fwww.estadao.com.br%2Fresizer%2Fnk960N-V_Hlzg0iLxJdyyV-p5po%3D%2Farc-anglerfish-arc2-prod-estadao%2Fpublic%2FMTDFNUJOIVAN5BMKB4SPSHOPEM.JPG&imgrefurl=https%3A%2F%2Fwww.estadao.com.br%2Fpaladar%2Freceita%2Fcreme-brulee%2F&docid=FwpjmwfVD_99uM&tbnid=6gCJQg57gAbsPM&vet=12ahUKEwimi_zvquSNAxX6rpUCHZ9NKJYQM3oECEEQAA..i&w=3200&h=2135&hcb=2&ved=2ahUKEwimi_zvquSNAxX6rpUCHZ9NKJYQM3oECEEQAA"),
                    new Prato("Tarte Tatin", "Torta de maçã caramelizada", "Sobremesa", 15.00, "https://www.google.com/imgres?q=tarte%20tatin&imgurl=https%3A%2F%2Fwww.177milkstreet.com%2Fassets%2Fsite%2FRecipes%2F_large%2FTarte-Tatin.jpg&imgrefurl=https%3A%2F%2Fwww.177milkstreet.com%2Frecipes%2Ftarte-tatin&docid=jGZlKgb_YMOOcM&tbnid=zjf6CRUY_WjdTM&vet=12ahUKEwjttufaquSNAxW_qpUCHQnTN4wQM3oECDIQAA..i&w=1600&h=1068&hcb=2&ved=2ahUKEwjttufaquSNAxW_qpUCHQnTN4wQM3oECDIQAA")
            ));
        }
    }


}
