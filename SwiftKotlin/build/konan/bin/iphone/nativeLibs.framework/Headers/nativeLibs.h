#import <Foundation/Foundation.h>

@class NativeLibsEntity, NativeLibsBrowseInteractor, NativeLibsBrowseRepository, NativeLibsBrowsePresenter, NativeLibsBrowseProduct, NativeLibsStdlibUnit, NativeLibsBrowseViewModel, NativeLibsRequestService, NativeLibsWords;

@protocol NativeLibsBrowseInteractorInput, NativeLibsBrowseInteractorOutput, NativeLibsBrowseRouting, NativeLibsBrowseViewOutput, NativeLibsBrowseViewInput;

NS_ASSUME_NONNULL_BEGIN

@interface KotlinBase : NSObject
-(instancetype) init __attribute__((unavailable));
+(instancetype) new __attribute__((unavailable));
+(void)initialize __attribute__((objc_requires_super));
@end;

@protocol NativeLibsBrowseInteractorInput
@required
-(void)loadData NS_SWIFT_NAME(loadData());
-(void)fireEntityChangedDidDataChange:(BOOL)didDataChange NS_SWIFT_NAME(fireEntityChanged(didDataChange:));
@end;

@protocol NativeLibsBrowseInteractorOutput
@required
-(void)didUpdateEntity:(NativeLibsEntity*)entity NS_SWIFT_NAME(didUpdate(entity:));
@end;

@interface NativeLibsBrowseInteractor : KotlinBase <NativeLibsBrowseInteractorOutput, NativeLibsBrowseInteractorInput>
-(instancetype)initWithRepository:(NativeLibsBrowseRepository*)repository NS_SWIFT_NAME(init(repository:)) NS_DESIGNATED_INITIALIZER;

@property (readonly) NSString* urlString;
@property NativeLibsEntity* entity;
@property id<NativeLibsBrowseInteractorOutput> _Nullable output;
@property id<NativeLibsBrowseRouting> _Nullable router;
@property (readonly) NativeLibsBrowseRepository* repository;
@end;

__attribute__((objc_subclassing_restricted))
@interface NativeLibsEntity : KotlinBase
-(instancetype)initWithBrowseProducts:(NSArray*)browseProducts NS_SWIFT_NAME(init(browseProducts:)) NS_DESIGNATED_INITIALIZER;

-(NSArray*)component1 NS_SWIFT_NAME(component1());
-(NativeLibsEntity*)doCopyBrowseProducts:(NSArray*)browseProducts NS_SWIFT_NAME(doCopy(browseProducts:));
@property (readonly) NSArray* browseProducts;
@end;

@protocol NativeLibsBrowseViewOutput
@required
-(void)loadData NS_SWIFT_NAME(loadData());
@end;

@interface NativeLibsBrowsePresenter : KotlinBase <NativeLibsBrowseInteractorOutput, NativeLibsBrowseViewOutput>
-(instancetype)initWithViewInput:(id<NativeLibsBrowseViewInput> _Nullable)viewInput interactorInput:(id<NativeLibsBrowseInteractorInput> _Nullable)interactorInput NS_SWIFT_NAME(init(viewInput:interactorInput:)) NS_DESIGNATED_INITIALIZER;

@property (readonly) id<NativeLibsBrowseViewInput> _Nullable viewInput;
@property (readonly) id<NativeLibsBrowseInteractorInput> _Nullable interactorInput;
@end;

__attribute__((objc_subclassing_restricted))
@interface NativeLibsBrowseProduct : KotlinBase
-(instancetype)initWithName:(NSString*)name manufacturer:(NSString*)manufacturer price:(NSString*)price sku:(NSString*)sku NS_SWIFT_NAME(init(name:manufacturer:price:sku:)) NS_DESIGNATED_INITIALIZER;

-(NSString*)component1 NS_SWIFT_NAME(component1());
-(NSString*)component2 NS_SWIFT_NAME(component2());
-(NSString*)component3 NS_SWIFT_NAME(component3());
-(NSString*)component4 NS_SWIFT_NAME(component4());
-(NativeLibsBrowseProduct*)doCopyName:(NSString*)name manufacturer:(NSString*)manufacturer price:(NSString*)price sku:(NSString*)sku NS_SWIFT_NAME(doCopy(name:manufacturer:price:sku:));
@property (readonly) NSString* name;
@property (readonly) NSString* manufacturer;
@property (readonly) NSString* price;
@property (readonly) NSString* sku;
@end;

@interface NativeLibsBrowseRepository : KotlinBase
-(instancetype)init NS_SWIFT_NAME(init()) NS_DESIGNATED_INITIALIZER;

-(void)loadDataUrlString:(NSString*)urlString completion:(NativeLibsStdlibUnit*(^)(NSArray*))completion NS_SWIFT_NAME(loadData(urlString:completion:));
@end;

@protocol NativeLibsBrowseRouting
@required
-(void)present NS_SWIFT_NAME(present());
@end;

@protocol NativeLibsBrowseViewInput
@required
-(void)setViewModel:(NativeLibsBrowseViewModel*)viewModel NS_SWIFT_NAME(set(viewModel:));
@end;

__attribute__((objc_subclassing_restricted))
@interface NativeLibsBrowseViewModel : KotlinBase
-(instancetype)initWithProducts:(NSArray*)products NS_SWIFT_NAME(init(products:)) NS_DESIGNATED_INITIALIZER;

-(NSArray*)component1 NS_SWIFT_NAME(component1());
-(NativeLibsBrowseViewModel*)doCopyProducts:(NSArray*)products NS_SWIFT_NAME(doCopy(products:));
@property (readonly) NSArray* products;
@end;

@interface NativeLibsRequestService : KotlinBase
-(instancetype)init NS_SWIFT_NAME(init()) NS_DESIGNATED_INITIALIZER;

@end;

@interface NativeLibsWords : KotlinBase
-(instancetype)init NS_SWIFT_NAME(init()) NS_DESIGNATED_INITIALIZER;

-(NSString* _Nullable)getWords NS_SWIFT_NAME(getWords());
-(void)insideCompletionHandler:(NativeLibsStdlibUnit*(^)(NSString*))completionHandler NS_SWIFT_NAME(inside(completionHandler:));
-(void)testingCompletionHandler:(NativeLibsStdlibUnit*(^)(NSString*))completionHandler NS_SWIFT_NAME(testing(completionHandler:));
-(void)test NS_SWIFT_NAME(test());
-(void)test2 NS_SWIFT_NAME(test2());
@end;

__attribute__((objc_subclassing_restricted))
@interface NativeLibsStdlibUnit : KotlinBase
+ (instancetype)unit NS_SWIFT_NAME(init());

@end;

NS_ASSUME_NONNULL_END
