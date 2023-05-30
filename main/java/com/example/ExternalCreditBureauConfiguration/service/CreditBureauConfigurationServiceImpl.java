package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.DTO.*;
import com.example.ExternalCreditBureauConfiguration.entity.*;
import com.example.ExternalCreditBureauConfiguration.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreditBureauConfigurationServiceImpl implements CreditBureauConfigurationService{
    @Autowired
    private CreditBureauConfigurationRepository creditBureauConfigurationRepository;
    @Autowired
    private CustomerRepository customerREpository;

    @Autowired
    private StatesRepository statesRepository;
    @Autowired
    private ProductIdRepository productIdRepository;
    @Autowired
    private LoanTypeRepository loanTypeRepository;
    @Autowired
    private CreditBureauAmountConfigurationRepository creditBureauAmountConfigurationRepository;
    @Autowired
    private CustomerCategoryRepository customerCategoryRepository;
    @Autowired
    private CreditBureauMiddleConfigurationRepository creditBureauMiddleConfigurationRepository;
    @Autowired
    private CreditBureauAvailableRepository creditBureauAvailableRepository;
    @Autowired
    private CreditBureauAmountLinkRepository creditBureauAmountLinkRepository;

    @Autowired
    private CustomerCategoryLinkService customerCategoryLinkService;

    @Autowired
    private StateLinkService stateLinkService;

    @Override
    public CreditBureauConfigurationDTO save(CreditBureauConfigurationDTO creditBureauConfiguration) {
        CreditBureauConfiguration creditBureauConfiguration1 = new CreditBureauConfiguration();
        BeanUtils.copyProperties(creditBureauConfiguration, creditBureauConfiguration1);
        List<CustomerCategoryLink> customerCategoryLinkDtoList = new ArrayList<>();

        creditBureauConfiguration.getCustomerCategoryLinkDto().forEach(customerCategoryLinkDto1 -> {
            CustomerCategoryLink customerCategoryLinkDto = new CustomerCategoryLink();
            customerCategoryLinkDto.setCustomerCategory(customerCategoryRepository.findById(
                    customerCategoryLinkDto1.getCustomerCategoryDTO().getId()
            ).get());
            customerCategoryLinkDto.setCreditBureauConfiguration(creditBureauConfiguration1);
            customerCategoryLinkDtoList.add(customerCategoryLinkDto);
            BeanUtils.copyProperties(customerCategoryLinkDto, creditBureauConfiguration.getCustomerCategoryLinkDto());
        });
        creditBureauConfiguration1.setCustomerCategoryLinkList(customerCategoryLinkDtoList);
        //stateLink
        List<StateLink> stateLinks = new ArrayList<>();
        creditBureauConfiguration.getStateLinkDTO().forEach(stateLinkDTO -> {
            StateLink stateLink = new StateLink();
            stateLink.setId(stateLinkDTO.getId());
            stateLink.setState(statesRepository.findById(stateLinkDTO.getStatesDTO().getId()).get());
            stateLink.setCreditBureauConfiguration(creditBureauConfiguration1);
            stateLinks.add(stateLink);
            BeanUtils.copyProperties(stateLink,creditBureauConfiguration.getStateLinkDTO());
        });
        creditBureauConfiguration1.setStateLink(stateLinks);

        //loanType
        creditBureauConfiguration1.setLoanType(loanTypeRepository.findById(creditBureauConfiguration.getLoanTypeDTO().getId()).get());

        //productId
        creditBureauConfiguration1.setProductId(productIdRepository.findById(creditBureauConfiguration.getProductIdDTO().getId()).get());

        //amountConfiguration
        List<CreditBureauAmountConfiguration> creditBureauAmountConfigurationList = new ArrayList<>();
        creditBureauConfiguration.getCreditBureauAmountConfigurationDTOS().forEach(creditBureauAmountConfigurationDTO -> {
            CreditBureauAmountConfiguration creditBureauAmountConfiguration= new CreditBureauAmountConfiguration();
            creditBureauAmountConfiguration.setId(creditBureauAmountConfigurationDTO.getId());
            creditBureauAmountConfiguration.setFromAmount(creditBureauAmountConfigurationDTO.getFromAmount());
            creditBureauAmountConfiguration.setToAmount(creditBureauAmountConfigurationDTO.getToAmount());

            List<CreditBureauAmountLink> creditBureauAmountLinks= new ArrayList<>();
            creditBureauAmountConfigurationDTO.getCreditBureauAmountDTOS().forEach(creditBureauAmountDTO -> {
                CreditBureauAmountLink creditBureauAmountLink = new CreditBureauAmountLink();
                creditBureauAmountLink.setId(creditBureauAmountDTO.getId());
                creditBureauAmountLink.setCreditBureauAvailable(creditBureauAvailableRepository.findById(creditBureauAmountDTO.getCreditBureauAvailableDTO().getId()).get());
                creditBureauAmountLinks.add(creditBureauAmountLink);
            });
            creditBureauAmountConfiguration.setCreditBureauAmountLinks(creditBureauAmountLinks);
            creditBureauAmountConfiguration.setToAmount(creditBureauAmountConfigurationDTO.getToAmount());
            creditBureauAmountConfigurationList.add(creditBureauAmountConfiguration);
            BeanUtils.copyProperties(creditBureauAmountConfigurationList,creditBureauConfiguration.getCreditBureauAmountConfigurationDTOS());
        });

        creditBureauConfiguration1.setCreditBureauAmountConfigurations(creditBureauAmountConfigurationList);

        //creditBureauMiddleConfiguration
        List<CreditBureauMiddleConfiguration> creditBureauMiddleConfigurationList = new ArrayList<>();
        creditBureauConfiguration.getCreditBureauMiddleConfigurationDTOS().forEach(creditBureauMiddleConfigurationDTO -> {
            CreditBureauMiddleConfiguration creditBureauMiddleConfiguration = new CreditBureauMiddleConfiguration();
            creditBureauMiddleConfiguration.setId(creditBureauMiddleConfigurationDTO.getId());
            creditBureauMiddleConfiguration.setAllowEnquiry(creditBureauMiddleConfigurationDTO.getAllowEnquiry());
            creditBureauMiddleConfiguration.setCbReportNeeded(creditBureauMiddleConfigurationDTO.getCbReportNeeded());
            creditBureauMiddleConfiguration.setManualEnquiryAllowed(creditBureauMiddleConfigurationDTO.getManualEnquiryAllowed());
            creditBureauMiddleConfiguration.setEnquiryValidity(creditBureauMiddleConfigurationDTO.getEnquiryValidity());
            creditBureauMiddleConfiguration.setCreditBureauAvailable(creditBureauAvailableRepository.findById(creditBureauMiddleConfigurationDTO.getCreditBureauAvailableDTO().getId()).get());
            creditBureauMiddleConfigurationList.add(creditBureauMiddleConfiguration);
            BeanUtils.copyProperties(creditBureauMiddleConfigurationList,creditBureauConfiguration.getCreditBureauMiddleConfigurationDTOS());
        });

        creditBureauConfiguration1.setCreditBureauMiddleConfiguration(creditBureauMiddleConfigurationList);
  //
        CreditBureauConfiguration creditBureauConfiguration2 = creditBureauConfigurationRepository.save(creditBureauConfiguration1);
        List<CustomerCategoryLinkDto> customerCategoryLinkDtos = new ArrayList<>();
        creditBureauConfiguration2.getCustomerCategoryLinkList().forEach(customerCategoryLink -> {
            CustomerCategoryLinkDto customerCategoryLinkDto = new CustomerCategoryLinkDto();
            customerCategoryLinkDto.setId(customerCategoryLink.getId());
            CustomerCategoryDTO customerCategoryDTO = new CustomerCategoryDTO();
            customerCategoryDTO.setId(customerCategoryLink.getCustomerCategory().getId());
            customerCategoryDTO.setCustomerCategoryTypes(customerCategoryLink.getCustomerCategory().getCustomerCategoryTypes());
            customerCategoryLinkDto.setCustomerCategoryDTO(customerCategoryDTO);
            BeanUtils.copyProperties(customerCategoryLinkDto, creditBureauConfiguration2.getCustomerCategoryLinkList());
            customerCategoryLinkDtos.add(customerCategoryLinkDto);
        });

        //states
        List<StateLinkDTO> stateLinkDTOList = new ArrayList<>();
        creditBureauConfiguration2.getStateLink().forEach(stateLink -> {
            StateLinkDTO stateLinkDTO = new StateLinkDTO();
            stateLinkDTO.setId(stateLink.getId());
            StatesDTO statesDTO = new StatesDTO();
            statesDTO.setId(stateLink.getState().getId());
            statesDTO.setStates(stateLink.getState().getStates());
            stateLinkDTO.setStatesDTO(statesDTO);
            BeanUtils.copyProperties(stateLinkDTO,creditBureauConfiguration2.getStateLink());
            stateLinkDTOList.add(stateLinkDTO);
        });

        LoanTypeDTO loanTypeDTO = new LoanTypeDTO();
        loanTypeDTO.setId(creditBureauConfiguration2.getLoanType().getId());
        loanTypeDTO.setLoanTypes(creditBureauConfiguration2.getLoanType().getLoanTypes());
        BeanUtils.copyProperties(loanTypeDTO,creditBureauConfiguration2.getLoanType());

        ProductIdDTO productIdDto = new ProductIdDTO();
        productIdDto.setId(creditBureauConfiguration2.getProductId().getId());
        productIdDto.setProductId(creditBureauConfiguration2.getProductId().getProductId());
        BeanUtils.copyProperties(productIdDto,creditBureauConfiguration2.getProductId());
//
        List<CreditBureauAmountConfigurationDTO> creditBureauAmountConfigurationDTOList = new ArrayList<>();

        creditBureauConfiguration2.getCreditBureauAmountConfigurations().forEach(creditBureauAmountConfiguration -> {
            CreditBureauAmountConfigurationDTO creditBureauAmountConfigurationDTO = new CreditBureauAmountConfigurationDTO();
            creditBureauAmountConfigurationDTO.setId(creditBureauAmountConfigurationDTO.getId());
            creditBureauAmountConfigurationDTO.setFromAmount(creditBureauAmountConfiguration.getFromAmount());
            creditBureauAmountConfigurationDTO.setToAmount(creditBureauAmountConfiguration.getToAmount());
            BeanUtils.copyProperties(creditBureauAmountConfigurationDTO,creditBureauConfiguration2.getCreditBureauAmountConfigurations());
            creditBureauAmountConfigurationDTOList.add(creditBureauAmountConfigurationDTO);
        });
  //
        List<CreditBureauMiddleConfigurationDTO> creditBureauMiddleConfigurationDTOList = new ArrayList<>();
        creditBureauConfiguration2.getCreditBureauMiddleConfiguration().forEach(creditBureauMiddleConfiguration -> {
            CreditBureauMiddleConfigurationDTO creditBureauMiddleConfigurationDTO = new CreditBureauMiddleConfigurationDTO();
            creditBureauMiddleConfigurationDTO.setId(creditBureauMiddleConfigurationDTO.getId());
            creditBureauMiddleConfigurationDTO.setAllowEnquiry(creditBureauMiddleConfigurationDTO.getAllowEnquiry());
            creditBureauMiddleConfigurationDTO.setEnquiryValidity(creditBureauMiddleConfigurationDTO.getEnquiryValidity());
            creditBureauMiddleConfigurationDTO.setCbReportNeeded(creditBureauMiddleConfigurationDTO.getCbReportNeeded());
            creditBureauMiddleConfigurationDTO.setManualEnquiryAllowed(creditBureauMiddleConfigurationDTO.getManualEnquiryAllowed());
            BeanUtils.copyProperties(creditBureauMiddleConfigurationDTO,creditBureauConfiguration2.getCreditBureauMiddleConfiguration());
            creditBureauMiddleConfigurationDTOList.add(creditBureauMiddleConfigurationDTO);
        });


        BeanUtils.copyProperties(creditBureauConfiguration2, creditBureauConfiguration);
        creditBureauConfiguration.setCustomerCategoryLinkDto(customerCategoryLinkDtos);
        creditBureauConfiguration.setStateLinkDTO(stateLinkDTOList);
        creditBureauConfiguration.setLoanTypeDTO(loanTypeDTO);
        creditBureauConfiguration.setProductIdDTO(productIdDto);
        creditBureauConfiguration.setCreditBureauAmountConfigurationDTOS(creditBureauAmountConfigurationDTOList);
        creditBureauConfiguration.setCreditBureauMiddleConfigurationDTOS(creditBureauMiddleConfigurationDTOList);
        return creditBureauConfiguration;
    }

    @Override
    public CreditBureauConfigurationDTO update(CreditBureauConfigurationDTO creditBureauConfigurationDTO, Long id) {
//        CreditBureauConfiguration creditBureauConfiguration = new CreditBureauConfiguration();
//        CreditBureauConfiguration creditModel = fetchById(id);
//        List<CustomerCategoryLink> customerCategoryLinkList = new ArrayList<>();
//
//        List<CustomerCategoryLink> customerCategoryLinkModel = customerCategoryLinkService.findAllCategories();
//        List<StateLink> stateLinksModel = stateLinkService.findAllStates();
//
//
        return null;
   }
//
//    @Override
//    public CreditBureauConfiguration fetchById(Long id) {
//        Optional<CreditBureauConfiguration> optionalId = creditBureauConfigurationRepository.findById(id);
//        return optionalId.get();
//    }
}
