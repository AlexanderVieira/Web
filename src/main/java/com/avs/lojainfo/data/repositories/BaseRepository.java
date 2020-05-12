package com.avs.lojainfo.data.repositories;

/*
 * @Repository public class BaseRepository<T, ID extends Serializable> extends
 * SimpleJpaRepository<T, ID> implements IBaseRepository<T, ID> {
 * 
 * private final EntityManager _entityManager;
 * 
 * public BaseRepository(Class<T> domainClass, EntityManager em) {
 * super(domainClass, em); _entityManager = em; }
 * 
 * @Transactional
 * 
 * @Override public void deleteById(ID id) { T deleted =
 * _entityManager.find(this.getDomainClass(), id); if (deleted != null) {
 * _entityManager.remove(deleted); } }
 * 
 * @Transactional
 * 
 * @Override public List<T> findAll() { // TODO Auto-generated method stub
 * return super.findAll(); }
 * 
 * @Transactional
 * 
 * @Override public Optional<T> findById(ID id) { // TODO Auto-generated method
 * stub return super.findById(id); }
 * 
 * @Transactional
 * 
 * @Override public <S extends T> S save(S entity) { // TODO Auto-generated
 * method stub return super.save(entity); }
 * 
 * @Transactional
 * 
 * @Override public <S extends T> S saveAndFlush(S entity) { // TODO
 * Auto-generated method stub return super.saveAndFlush(entity); }
 * 
 * @Transactional
 * 
 * @Override public <S extends T> List<S> saveAll(Iterable<S> entities) { //
 * TODO Auto-generated method stub return super.saveAll(entities); }
 * 
 * @Transactional
 * 
 * @Override public boolean existsById(ID id) { // TODO Auto-generated method
 * stub return super.existsById(id); }
 * 
 * }
 */
