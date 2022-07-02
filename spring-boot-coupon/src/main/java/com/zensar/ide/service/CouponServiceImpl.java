package com.zensar.ide.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.ide.dto.CouponDto;
import com.zensar.ide.entity.Coupon;
import com.zensar.ide.exceptions.CouponAlreadyExistsException;
import com.zensar.ide.exceptions.NoSuchCouponExistsException;
import com.zensar.ide.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CouponServiceImpl() {
	}

	@Override
	public CouponDto getCoupon(int couponId) {
		Coupon getCoupon = couponRepository.findById(couponId).orElse(null);
		if(getCoupon == null)
			throw new NoSuchCouponExistsException("Coupon doesnt exists");
		return modelMapper.map(getCoupon, CouponDto.class);
		// return mapToDto(getCoupon);
	}

	@Override
	// public List<CouponDto> getCoupons() {
	public List<CouponDto> getCoupons(int pageNumber, int pageSize, String sortBy, Direction dir) {
		// List<Coupon> listOfCoupons = couponRepository.findAll();
		// Page<Coupon> findAll = couponRepository.findAll(PageRequest.of(1, 5));
		// Page<Coupon> findAll =
		// couponRepository.findAll(PageRequest.of(pageNumber,pageSize));
		// Page<Coupon> findAll =
		// couponRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"couponCode")));
		Page<Coupon> findAll = couponRepository.findAll(PageRequest.of(pageNumber, pageSize, dir, sortBy));
		List<Coupon> content = findAll.getContent();
		List<CouponDto> listOfCouponDto = new ArrayList<CouponDto>();
		/*
		 * for (Coupon coupon : listOfCoupons) {
		 * //listOfCouponDto.add(mapToDto(coupon));
		 * listOfCouponDto.add(modelMapper.map(coupon,CouponDto.class)); }
		 */
		for (Coupon coupon : content)
			listOfCouponDto.add(modelMapper.map(coupon, CouponDto.class));
		return listOfCouponDto;
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
		/*
		 * Coupon coupon = new Coupon(); coupon.setCouponId(couponDto.getCouponId());
		 * coupon.setCouponCode(couponDto.getCouponCode());
		 * coupon.setExpDate(couponDto.getExpDate());
		 * coupon.setCouponPrice(couponDto.getCouponPrice());
		 * coupon.setCouponDesc(couponDto.getCouponDesc());
		 */
		// Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon getCoupon = couponRepository.findById(coupon.getCouponId()).orElse(null);
		if(getCoupon == null) {
			Coupon insertedCoupon = couponRepository.save(coupon);
			// return mapToDto(insertedCoupon);
			return modelMapper.map(insertedCoupon, CouponDto.class);
		}
		else
			throw new CouponAlreadyExistsException("Coupon already exists");

	}

	@Override
	public void updateCoupon(int couponId, CouponDto couponDto) {
		/*
		 * Coupon coupon = new Coupon(); coupon.setCouponId(couponDto.getCouponId());
		 * coupon.setCouponCode(couponDto.getCouponCode());
		 * coupon.setExpDate(couponDto.getExpDate());
		 * coupon.setCouponPrice(couponDto.getCouponPrice());
		 * coupon.setCouponDesc(couponDto.getCouponDesc());
		 */
		// Coupon coupon = mapToEntity(couponDto);
		Coupon getCoupon = couponRepository.findById(couponId).orElse(null);
		if(getCoupon == null)
			throw new NoSuchCouponExistsException("Coupon doesn't exists");
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		couponRepository.save(coupon);

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);

	}

	@Override
	public CouponDto getByCouponCode(String couponCode) {
		// List<Coupon> findBycouponCode =
		Coupon findByCouponCode = couponRepository.findByCouponCode(couponCode);
		//List<Coupon> findBycouponCode = couponRepository.test(couponCode);
		//List<CouponDto> couponDtos = new ArrayList<CouponDto>();
		//for (Coupon coupon : findBycouponCode)
			//couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		CouponDto couponDto = modelMapper.map(findByCouponCode,CouponDto.class);
		return couponDto;
	}

	@Override
	public List<CouponDto> getByCouponCodeOrCouponPrice(String couponCode, int price) {
		List<Coupon> findBycouponCode = couponRepository.findByCouponCodeOrCouponPrice(couponCode, price);
		List<CouponDto> couponDtos = new ArrayList<CouponDto>();
		for (Coupon coupon : findBycouponCode)
			couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		return couponDtos;
	}

	@Override
	public List<CouponDto> getByCouponCodeAndExpDate(String couponCode, String expDate) {
		// List<Coupon> findBycouponCode =
		// couponRepository.findByCouponCodeAndExpDate(couponCode, expDate);
		List<Coupon> findBycouponCode = couponRepository.test1(couponCode, expDate);
		List<CouponDto> couponDtos = new ArrayList<CouponDto>();
		for (Coupon coupon : findBycouponCode)
			couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		return couponDtos;
	}

	@Override
	public List<CouponDto> getByCouponCodeOrderByCouponPrice(String couponCode) {
		List<Coupon> findBycouponCode = couponRepository.findByCouponCodeOrderByCouponPrice(couponCode);
		List<CouponDto> couponDtos = new ArrayList<CouponDto>();
		for (Coupon coupon : findBycouponCode)
			couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		return couponDtos;
	}

	/*
	 * public Coupon mapToEntity(CouponDto couponDto) { Coupon coupon = new
	 * Coupon(); coupon.setCouponId(couponDto.getCouponId());
	 * coupon.setCouponCode(couponDto.getCouponCode());
	 * coupon.setExpDate(couponDto.getExpDate());
	 * coupon.setCouponPrice(couponDto.getCouponPrice());
	 * coupon.setCouponDesc(couponDto.getCouponDesc()); return coupon; }
	 */
	/*
	 * public CouponDto mapToDto(Coupon coupon) { CouponDto couponDto = new
	 * CouponDto(); couponDto.setCouponId(coupon.getCouponId());
	 * couponDto.setCouponCode(coupon.getCouponCode());
	 * couponDto.setExpDate(coupon.getExpDate());
	 * couponDto.setCouponPrice(coupon.getCouponPrice());
	 * couponDto.setCouponDesc(coupon.getCouponDesc()); return couponDto; }
	 */

}
