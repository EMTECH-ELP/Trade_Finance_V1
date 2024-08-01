//package com.TradeFinance.bankguarantee.controller;
//
//import com.TradeFinance.bg.entities.GoodsShipment;
//import com.TradeFinance.bg.services.GoodsShipmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("api/v1/goods-shipments")
//public class    GoodsShipmentController {
//
//    @Autowired
//    private GoodsShipmentService goodsShipmentService;
//
//    @GetMapping
//    public ResponseEntity<List<GoodsShipment>> getAllGoodsShipments() {
//        List<GoodsShipment> goodsShipments = goodsShipmentService.getAllGoodsShipments();
//        return new ResponseEntity<>(goodsShipments, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GoodsShipment> getGoodsShipmentById(@PathVariable Long id) {
//        Optional<GoodsShipment> goodsShipment = goodsShipmentService.getGoodsShipmentById(id);
//        return goodsShipment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public ResponseEntity<GoodsShipment> createGoodsShipment(@RequestBody GoodsShipment goodsShipment) {
//        GoodsShipment savedGoodsShipment = goodsShipmentService.saveGoodsShipment(goodsShipment);
//        return new ResponseEntity<>(savedGoodsShipment, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteGoodsShipment(@PathVariable Long id) {
//        goodsShipmentService.deleteGoodsShipment(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
