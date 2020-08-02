package br.com.fiap.rwsfiaplembretes.service.impl;

import br.com.fiap.rwsfiaplembretes.config.LembreteAMQPConfig;
import br.com.fiap.rwsfiaplembretes.dto.LembreteDTO;
import br.com.fiap.rwsfiaplembretes.entity.Lembrete;
import br.com.fiap.rwsfiaplembretes.repository.LembreteRepository;
import br.com.fiap.rwsfiaplembretes.service.LembreteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LembreteServiceImpl implements LembreteService {

    private LembreteRepository lembreteRepository;

    public LembreteServiceImpl(LembreteRepository lembreteRepository) {
        this.lembreteRepository = lembreteRepository;
    }

    private Lembrete getLembrete(Integer id) {
        return lembreteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<LembreteDTO> findAll() {
        List<Lembrete> customerList = lembreteRepository.findAll();
        return customerList.stream().map(LembreteDTO::new).collect(Collectors.toList());
    }

    @Override
    public LembreteDTO findById(Integer id) {
        return new LembreteDTO(getLembrete(id));
    }

    @Override
    public LembreteDTO create(LembreteDTO lembreteDTO) {
        sendLembreteToRabbit(lembreteDTO);
        Lembrete lembrete = lembreteRepository.save(new Lembrete(lembreteDTO));
        return new LembreteDTO(lembrete);
    }

    @Override
    public LembreteDTO update(LembreteDTO lembreteDTO) {
        Lembrete lembrete = getLembrete(lembreteDTO.getId());
        lembrete.setConteudo(lembreteDTO.getConteudo());
        lembrete.setPrioridadeEnum(lembreteDTO.getPrioridadeEnum());

        return new LembreteDTO(lembreteRepository.save(lembrete));
    }

    @Override
    public void delete(Integer id) {
        Lembrete lembrete = getLembrete(id);
        lembreteRepository.delete(lembrete);
    }

    public void sendLembreteToRabbit(LembreteDTO lembreteDTO) {
        try {
            String json = new ObjectMapper().writeValueAsString(lembreteDTO);

            RabbitAdmin admin = new RabbitAdmin(LembreteAMQPConfig.getConnection());
            Queue queueElevador = new Queue("lembretes");

            admin.declareQueue(queueElevador);

            FanoutExchange exchange = new FanoutExchange("lembretes");
            admin.declareExchange(exchange);

            admin.declareBinding(BindingBuilder.bind(queueElevador).to(exchange));

            RabbitTemplate template = new RabbitTemplate(LembreteAMQPConfig.getConnection());

            template.convertAndSend("lembretes", "lembretes", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
