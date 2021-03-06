package qmstore.user_address.manager.impl;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import qmstore.user_address.dao.UserAddressDao;
import qmstore.user_address.manager.UserAddressManager;
import qmstore.user_address.pojo.UserAddress;
import qmstore.util.Response;

import javax.annotation.Resource;

@Component
public class UserAddressManagerImpl implements UserAddressManager {
    @Resource
    UserAddressDao userAddressDao;

    @Override
    public Response insertUserAddress(UserAddress userAddress) {
        try{
            System.out.println("UserAddressManagerImpl insertUserAddress");
            if(StringUtils.isEmpty(userAddress.getAddressId())){
                System.out.println("serAddress.getAddressId().isEmpty(");
                userAddress.setAddressId(IdUtil.simpleUUID());
            }
            return Response.SUCCESS(userAddressDao.insertUserAddress(userAddress));
        }catch (Exception e) {
            return Response.ERROR(e.getMessage());
        }
    }

    @Override
    public Response deleteUserAddress(String userId, String addressId) {
        try{
            return Response.SUCCESS(userAddressDao.deleteUserAddress(userId, addressId));
        }catch (Exception e) {
            return Response.ERROR(e.getMessage());
        }    }

    @Override
    public Response updateUserAddress(UserAddress userAddress) {
        try{
            return Response.SUCCESS(userAddressDao.updateUserAddress(userAddress));
        }catch (Exception e) {
            return Response.ERROR(e.getMessage());
        }    }

    @Override
    public Response selectUserAddressByUserId(String userId) {
        try{
            return Response.SUCCESS(userAddressDao.selectUserAddressByUserId(userId));
        }catch (Exception e) {
            return Response.ERROR(e.getMessage());
        }    }

    @Override
    public Response selectUserAddressByUserIdAndAddressId(String userId, String addressId) {
        try{
            return Response.SUCCESS(userAddressDao.selectUserAddressByUserIdAndAddressId(userId,addressId));
        }catch (Exception e) {
            return Response.ERROR(e.getMessage());
        }    }
}
