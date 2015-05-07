%module(directors="1") quickmsg_py
%include "swig_includes.i"

%{
#include "quickmsg/client.hpp"
#include "quickmsg/publisher.hpp"
#include "quickmsg/subscriber.hpp"
#include "quickmsg/service.hpp"
using namespace quickmsg;
%}

//%shared_ptr(quickmsg::Message)
//%shared_ptr(quickmsg::ServiceReply)

%feature("director") Service;
%feature("director") Subscriber;
%feature("director") AsyncSubscriber;

%include "quickmsg/types.hpp"
%include "quickmsg/publisher.hpp"
%include "quickmsg/subscriber.hpp"
%include "quickmsg/service.hpp"
%include "quickmsg/client.hpp"


