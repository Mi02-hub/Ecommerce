package com.senai.ecommerce.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.RelatorioPedidoDTO;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.repositories.PedidoRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class RelatorioService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public void gerarRelatorio(String caminho) throws JRException {
        try {
            // Busca de dados do banco
            List<Pedido> pedidos = pedidoRepository.findAll();
            System.out.println("Total de pedidos encontrados: " + pedidos.size());
            
            // Converter para DTOs com tratamento de nulos
            List<RelatorioPedidoDTO> relatorio = new ArrayList<>();
            
            for (Pedido pedido : pedidos) {
                RelatorioPedidoDTO dto = new RelatorioPedidoDTO();
                
                // Tratar cliente nulo
                if (pedido.getCliente() != null) {
                    dto.setCliente(pedido.getCliente().getId());
                } else {
                    dto.setCliente(0L);
                }
                
                // ID do pedido
                dto.setPedido(pedido.getId());
                
                // Tratar status nulo
                if (pedido.getStatus() != null) {
                    dto.setStatus(pedido.getStatus().toString());
                } else {
                    dto.setStatus("Status não definido");
                }
                
                // Tratar momento nulo
                if (pedido.getMomento() != null) {
                    dto.setMomento(pedido.getMomento().atZone(ZoneId.systemDefault())
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                } else {
                    dto.setMomento("Data não informada");
                }
                
                relatorio.add(dto);
            }
            
            System.out.println("Total de registros no relatório: " + relatorio.size());
            
            try {
                // DataSource do relatório 
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(relatorio);

                // Parâmetros do relatório 
                Map<String, Object> parametro = new HashMap<>();
                parametro.put("titulo", "Relatório de Pedidos");

                try {
                    // Compilação do relatório 
                    JasperReport jasperReport = JasperCompileManager.compileReport
                    (getClass().getResourceAsStream("/relatorios/relatorio_pedidos.jrxml"));

                    try {
                        // Preenchimento do relatório 
                        JasperPrint jasperPrint = JasperFillManager.fillReport
                        (jasperReport, parametro, dataSource);

                        try {
                            // Verificar se o diretório existe
                            File file = new File(caminho);
                            File parentDir = file.getParentFile();
                            if (parentDir != null && !parentDir.exists()) {
                                parentDir.mkdirs();
                            }

                            // Exportação do relatório 
                            JasperExportManager.exportReportToPdfFile
                            (jasperPrint, caminho);
                            
                            System.out.println("Relatório gerado com sucesso em: " + caminho);
                        } catch (Exception e) {
                            throw new RuntimeException("Erro ao expaortar relatório para PDF: " + e.getMessage(), e);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("Erro ao preencher relatório: " + e.getMessage(), e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Erro ao compilar relatório: " + e.getMessage(), e);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro ao preparar dados do relatório: " + e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro durante a geração do relatório: " + e.getMessage(), e);
        }
    }

}
